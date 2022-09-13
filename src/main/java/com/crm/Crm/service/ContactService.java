package com.crm.Crm.service;

import com.crm.Crm.Exception.SearchFieldNotFoundException;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.SearchConfiguration;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

import java.util.List;

public interface ContactService extends CrmBaseEntityService {

    public ContactDto updateContactDetails(Long id,ContactDto contactDto);

    SearchConfiguration getSearchParams();
}
