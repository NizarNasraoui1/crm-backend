package com.crm.Crm.Repository.Generic;

import com.crm.Crm.entity.baseEntity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}
