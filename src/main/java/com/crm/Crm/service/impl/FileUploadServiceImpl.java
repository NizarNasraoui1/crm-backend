package com.crm.Crm.service.impl;

import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.entity.File;
import com.crm.Crm.enumeration.AllowedFileTypes;
import com.crm.Crm.repository.CrmBaseEntityRepository;
import com.crm.Crm.repository.FileRepository;
import com.crm.Crm.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private CrmBaseEntityRepository crmBaseEntityRepository;
    @Value("${file-upload-path}")
    private String root;

    public void saveFilePathInDatabase(MultipartFile file,Long crmBaseEntityId){
        CrmBaseEntity crmBaseEntity=crmBaseEntityRepository.findById(crmBaseEntityId).orElseThrow(()->new EntityNotFoundException());
        fileRepository.save(new File(null,file.getOriginalFilename().toString(),crmBaseEntity));

    }


    @Override
    @Transactional
    public void uploadFile(MultipartFile file,Long crmBaseEntityId) {
        try {
            if(!checkIfFileAlreadyExists(file)){
                checkFileType(file);
                Files.copy(file.getInputStream(), Paths.get(this.root).resolve(file.getOriginalFilename()));
                this.saveFilePathInDatabase(file,crmBaseEntityId);
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkIfFileAlreadyExists(MultipartFile file){
        return fileRepository.existsByPath(file.getOriginalFilename());
    }

    @Override
    @Transactional
    public void deleteFile(String fileName) throws IOException {
            Path file = Paths.get(this.root).resolve(fileName);
            if(!Files.deleteIfExists(file)){
                throw new IOException("file does not exist");
            }
            Optional<File> fileEntity=fileRepository.findFileByPath(fileName);
            if(fileEntity.isPresent()){
                fileRepository.delete(fileEntity.get());

            }
            else{
                throw new EntityNotFoundException("file does not exist");
            }
    }

    @Override
    public List<String> getCrmBaseEntityFileNames(Long id) {
        return fileRepository.findAllByCrmBaseEntity(id);
    }

    public static void checkFileType(MultipartFile file) throws Exception{
            String[]splittedFileName=file.getOriginalFilename().split("\\.");
            if(splittedFileName.length!=2) throw new Exception("unsupported file extension");
            String fileType=splittedFileName[1];
            boolean isAllowedType=false;
            for(AllowedFileTypes allowedFileType:AllowedFileTypes.values()){
                if(fileType.equalsIgnoreCase(allowedFileType.toString())){
                    isAllowedType=true;
                }
            }
            if(!isAllowedType) throw new Exception("not allowed type");

        }


        public java.net.URI getAbsolutePath(String filename) {
            Path file = Paths.get(this.root).resolve(filename);
            return file.toUri();
        }

}
