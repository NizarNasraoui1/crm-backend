package com.crm.Crm.resource;

import com.crm.Crm.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("api/file")
public class FileUploadResource {
    @Autowired
    FileUploadService fileUploadService;
    @PostMapping("/upload/crm-base-entity/{id}")
    public ResponseEntity<?>uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long id){
            fileUploadService.uploadFile(file,id);
            return ResponseEntity.ok("file uploaded successfully");

    }

}
