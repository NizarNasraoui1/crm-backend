package com.crm.Crm.generic;

import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

import java.util.List;
import java.util.Optional;

public interface GenericService<T,D,R extends GenericRepository<T>,M extends GenericMapper<T,D>>  {

    D findById(Long id);
    List<D> findAll() throws Exception;
    D save(D entity) throws Exception;
    void delete(Long id) throws Exception;

//    FilteredPageWrapper<D> getFilteredPage(String searchWord,SearchFields searchFields,int page, int pageSize,String sortField, String sortDirection);


}