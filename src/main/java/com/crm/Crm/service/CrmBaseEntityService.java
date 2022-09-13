package com.crm.Crm.service;

import com.crm.Crm.dto.*;
import com.crm.Crm.dto.commons.FilteredPageWrapper;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.dto.commons.SearchFields;

public interface CrmBaseEntityService{

    CrmBaseEntityDto getCrmBaseEntityById(Long id);

    public void deleteCrmBaseEntityById(Long id);

    SearchConfiguration getSearchParams();
    FilteredPageWrapper<CrmBaseEntityDto> getCrmBaseEntityFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);
    NoteDto getNoteByCrmBaseEntityNote(Long id);
}
