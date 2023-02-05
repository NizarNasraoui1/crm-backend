package com.crm.Crm.repository;

import com.crm.Crm.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File,Long> {
    Optional<File>findFileByPath(String fileName);
    @Query("select count(*) from File")
    int countFiles();
}
