package com.crm.Crm.repository;

import com.crm.Crm.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FileRepository extends JpaRepository<File,Long> {
    Optional<File>findFileByPath(String fileName);
    @Query("select count(*) from File")
    int countFiles();

    @Query("SELECT path FROM File f WHERE crm_base_entity_id=:crmBaseEntityId")
    List<String> findAllByCrmBaseEntity(@Param("crmBaseEntityId") Long crmBaseEntityId);

    boolean existsByPath(String path);
}
