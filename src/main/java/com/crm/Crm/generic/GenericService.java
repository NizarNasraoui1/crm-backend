package com.crm.Crm.generic;

import java.util.List;

public interface GenericService<T,D,R extends GenericRepository<T>,M extends GenericMapper<T,D>>  {

    D findById(Long id);
    List<D> findAll() throws Exception;
    D save(D entity) throws Exception;
    void delete(Long id) throws Exception;

//    FilteredPageWrapper<D> getFilteredPage(String searchWord,SearchFields searchFields,int page, int pageSize,String sortField, String sortDirection);


}