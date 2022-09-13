package com.crm.Crm.service.impl;

import com.crm.Crm.Repository.ContactRepository;
import com.crm.Crm.dto.*;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.enumeration.ContactSearchFields;
import com.crm.Crm.enumeration.ContactSortFields;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl extends CrmBaseEntityServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactMapper contactMapper;


    @Override
    public ContactDto findContactById(Long id) {
        return contactMapper.toDto((Contact) contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found")));
    }

    @Override
    public ContactDto saveContact(ContactDto contactDto) {
        return contactMapper.toDto(contactRepository.save(contactMapper.toBo(contactDto)));
    }

    @Override
    public ContactDto updateContactDetails(Long id, ContactDto contactDto) {
        Contact updateContact= (Contact) contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
        updateContact.setFirstName(contactDto.getFirstName());
        updateContact.setLastName(contactDto.getLastName());
        updateContact.setAddress(contactDto.getAddress());
        updateContact.setEmail(contactDto.getEmail());
        return contactMapper.toDto(new Contact());
    }



    @Override
    public SearchConfiguration getSearchParams() {
        SearchConfiguration searchConfiguration=new SearchConfiguration();
        for(ContactSortFields sortField: ContactSortFields.values()){
            searchConfiguration.getSortFields().add(new ParamDto(sortField.name,sortField.label));
        }
        for(ContactSearchFields searchField: ContactSearchFields.values()){
            searchConfiguration.getSearchFields().add(new ParamDto(searchField.name,searchField.label));
        }
        return searchConfiguration;
    }
}
