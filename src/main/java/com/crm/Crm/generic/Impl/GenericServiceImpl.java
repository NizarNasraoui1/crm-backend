package com.crm.Crm.generic.Impl;

import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.*;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<T extends GenericEntity,D> implements GenericService<T,D> {

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

    public FilteredPageWrapper<D> getFilteredPage(String searchWord,SearchFields searchFields,int page, int pageSize,String sortField, String sortDirection) {
        PageRequest pageRequest= PaginationAndFilteringUtil.getPaginationRequest(page,pageSize,sortField,sortDirection);
        GenericSearchSpecification<T> genericSearchSpecification=new GenericSearchSpecification<>();
        Page<T> resultPage;
        if(!searchFields.getSearchFields().isEmpty()){
            Specification<T>filterSpecification= genericSearchSpecification.getGenericSearchSpecification(searchWord, searchFields);
            resultPage=genericRepository.findAll(filterSpecification,pageRequest);
        }
        else{
            resultPage=genericRepository.findAll(pageRequest);
        }
        FilteredPageWrapper<D> filteredPageWrapper=new FilteredPageWrapper<>(resultPage.getTotalPages(),mapper.toDtos(resultPage.getContent()));
        return filteredPageWrapper;
    }



}

