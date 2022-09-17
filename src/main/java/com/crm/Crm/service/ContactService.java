package com.crm.Crm.service;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.commons.FilteredPageWrapper;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.dto.commons.SearchFields;

public interface ContactService extends CrmBaseEntityService{

    ContactDto findContactById(Long id);

    ContactDto saveContact(ContactDto contactDto);

    ContactDto updateContactDetails(Long id,ContactDto contactDto);

    void deleteContact(Long id);

    SearchConfiguration getSearchParams();

    FilteredPageWrapper<ContactDto> getContactFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);

   // FilteredPageWrapper<ContactDto> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection);

}
