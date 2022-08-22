package com.crm.Crm.service.impl;

import com.crm.Crm.Repository.ContactRepository;
import com.crm.Crm.Repository.ContactSearchCriteria;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.service.ContactService;
import com.crm.Crm.generic.Impl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactServiceImpl extends GenericServiceImpl<Contact, ContactDto> implements ContactService {
    @Autowired
    ContactSearchCriteria contactSearchCriteria;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactMapper contactMapper;
    public FilteredPageWrapper<ContactDto>getContactFilteredPage(int page, int rows, String searchWord,String sortField){
        List<String>searchWords= Arrays.asList("firstName","lastName");
        List<ContactDto> contactDtoList=contactMapper.toDtos(contactRepository.getFilteredPage( page,  rows, "ali", searchWords, sortField,Contact.class));
        return new FilteredPageWrapper<ContactDto>(contactDtoList.size(),contactDtoList);
    }
}
