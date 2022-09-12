package com.crm.Crm.service;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

public interface CrmBaseEntityService extends GenericService<CrmBaseEntity, CrmBaseEntityDto> {
    FilteredPageWrapper<CrmBaseEntityDto> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);
    NoteDto getNoteByCrmBaseEntityNote(Long id);
}
