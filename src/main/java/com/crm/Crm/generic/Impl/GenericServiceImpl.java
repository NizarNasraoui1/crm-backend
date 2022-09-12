package com.crm.Crm.generic.Impl;

import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.*;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends GenericEntity,D,M extends GenericMapper<T,D>> implements GenericService<T,D,M> {
    @Autowired
    M mapper;
    @Autowired
    protected GenericRepository<T> genericRepository;

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

