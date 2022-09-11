package com.crm.Crm.service;

import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

public interface CrmBaseEntityService<T extends GenericEntity,D> extends GenericService<T,D> {
    FilteredPageWrapper<D> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);

}
