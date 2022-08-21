package com.crm.Crm.service.generic.impl;

import com.crm.Crm.Repository.Generic.GenericRepository;
import com.crm.Crm.entity.baseEntity.BaseEntity;
import com.crm.Crm.mapper.generic.GenericMapper;
import com.crm.Crm.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends BaseEntity,D> implements GenericService<T> {

    @Autowired
    protected GenericRepository<T> genericRepository;

    @Autowired
    protected GenericMapper<T,D> mapper;

    @Override
    public Optional<T> findById(Long id) {
        return genericRepository.findById(id);
    }

    @Override
    public List<T> findAll() throws Exception {
        try {
            return genericRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public T save(T entity) throws Exception {
        try {
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }

}

