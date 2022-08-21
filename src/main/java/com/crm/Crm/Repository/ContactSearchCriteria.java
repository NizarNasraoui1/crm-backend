package com.crm.Crm.Repository;

import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;

import java.util.List;


public interface ContactSearchCriteria {
    public List<Contact> getContactFilteredPage(int page, int rows, String searchWord, String sortField);
}
