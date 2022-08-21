package com.crm.Crm.generic.Impl;

import com.crm.Crm.generic.BaseEntity;
import com.crm.Crm.generic.GenericMapper;
import com.crm.Crm.generic.GenericRepository;
import com.crm.Crm.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

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

