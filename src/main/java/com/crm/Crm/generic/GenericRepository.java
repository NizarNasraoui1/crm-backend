package com.crm.Crm.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
