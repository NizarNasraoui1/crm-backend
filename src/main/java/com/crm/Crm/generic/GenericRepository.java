package com.crm.Crm.generic;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

}