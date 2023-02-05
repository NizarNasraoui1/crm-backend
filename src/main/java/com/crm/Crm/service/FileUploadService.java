package com.crm.Crm.service;

import com.crm.Crm.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService{
    void uploadFile(MultipartFile file,Long crmBaseEntityId);
    void deleteFile(String fileName) throws IOException;
}
