package com.crm.Crm.service;

import com.crm.Crm.Repository.CrmBaseEntityRepo;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;

public interface CrmBaseEntityService extends GenericService<CrmBaseEntity, CrmBaseEntityDto, CrmBaseEntityRepo, CrmBaseEntityMapper> {
    FilteredPageWrapper<CrmBaseEntityDto> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);
    NoteDto getNoteByCrmBaseEntityNote(Long id);
}
