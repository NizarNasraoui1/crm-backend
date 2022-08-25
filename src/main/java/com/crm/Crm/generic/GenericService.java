package com.crm.Crm.generic;

import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.enumeration.SortDirection;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

import java.util.List;
import java.util.Optional;

public interface GenericService<T extends GenericEntity>  {

    Optional<T>findById(Long id);
    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;

    FilteredPageWrapper<T> getFilteredPage(String searchWord,SearchFields searchFields,int page, int pageSize, SortDirection sortDirection);

}