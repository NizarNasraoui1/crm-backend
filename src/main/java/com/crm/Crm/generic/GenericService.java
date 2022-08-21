package com.crm.Crm.generic;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends GenericEntity>  {

    Optional<T>findById(Long id);
    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;

}