package com.crm.Crm.service;

import com.crm.Crm.Exception.SearchFieldNotFoundException;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

import java.util.List;

public interface ContactService extends GenericService<Contact> {
    public FilteredPageWrapper<ContactDto> getContactFilteredPage(int page, int rows, String searchWord, SearchFields searchFields, String sortField) throws SearchFieldNotFoundException;
}
