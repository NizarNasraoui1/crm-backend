package com.crm.Crm.generic.Impl;

import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.enumeration.SortDirection;
import com.crm.Crm.generic.*;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends GenericEntity,D> implements GenericService<T> {

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

    public FilteredPageWrapper<T> getFilteredPage(String searchWord,SearchFields searchFields,int page, int pageSize, SortDirection sortDirection) {
        PageRequest pageRequest= PaginationAndFilteringUtil.getPaginationRequest(page,pageSize,sortDirection);
        GenericSearchSpecification<T> genericSearchSpecification=new GenericSearchSpecification<>();
        Specification<T>filterSpecification= genericSearchSpecification.getGenericSearchSpecification(searchWord, searchFields);
        Page<T> resultPage=genericRepository.findAll(filterSpecification,pageRequest);
        FilteredPageWrapper<T> filteredPageWrapper=new FilteredPageWrapper<>(resultPage.getTotalPages(),resultPage.getContent());
        return filteredPageWrapper;
    }

}

