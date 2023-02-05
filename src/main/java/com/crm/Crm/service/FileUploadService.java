package com.crm.Crm.service;

import com.crm.Crm.entity.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService{
    void uploadFile(MultipartFile file,Long crmBaseEntityId);
}
