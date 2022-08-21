package com.crm.Crm.service.generic;

import com.crm.Crm.entity.baseEntity.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends BaseEntity>  {

    Optional<T>findById(Long id);
    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;

}