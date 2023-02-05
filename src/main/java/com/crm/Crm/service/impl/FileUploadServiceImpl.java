package com.crm.Crm.service.impl;

import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.entity.File;
import com.crm.Crm.repository.CrmBaseEntityRepository;
import com.crm.Crm.repository.FileRepository;
import com.crm.Crm.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private CrmBaseEntityRepository crmBaseEntityRepository;
    private final Path root = Paths.get("src/main/resources/uploaded-files");

    public void saveFile(MultipartFile file,Long crmBaseEntityId){
        CrmBaseEntity crmBaseEntity=crmBaseEntityRepository.findById(crmBaseEntityId).orElseThrow(()->new EntityNotFoundException());
        fileRepository.save(new File(null,file.getOriginalFilename().toString(),crmBaseEntity));

    }
    @Override
        public void uploadFile(MultipartFile file,Long crmBaseEntityId) {
            try {
                Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
                this.saveFile(file,crmBaseEntityId);

            } catch (Exception e) {
                if (e instanceof FileAlreadyExistsException) {
                    throw new RuntimeException("A file of that name already exists.");
                }

                throw new RuntimeException(e.getMessage());
            }
        }

}
