package com.crm.Crm.generic.Impl;

import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.*;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

public class GenericServiceImpl<T,D,R extends GenericRepository<T>,M extends GenericMapper<T,D>> implements GenericService<T,D,R,M> {
    M mapper;
    R genericRepository;

    @Override
    public D findById(Long id) {
        mapper.toDto((T) new CrmBaseEntity());
        T bo=genericRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("entity not found"));
        return mapper.toDto(bo);
    }

    @Override
    public List<D> findAll() throws Exception {
        try {
            return mapper.toDtos(genericRepository.findAll());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public D save(D entity) throws Exception {
        try {
            return mapper.toDto(genericRepository.save(mapper.toBo(entity)));
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

