package com.crm.Crm.service.impl;

import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.repository.CrmBaseEntityRepository;
import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.*;
import com.crm.Crm.dto.commons.FilteredPageWrapper;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.dto.commons.SearchFields;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.enumeration.ContactSearchFields;
import com.crm.Crm.enumeration.ContactSortFields;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import com.crm.Crm.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl extends CrmBaseEntityServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    CrmBaseEntityRepository crmBaseEntityRepository;
    @Autowired
    ContactMapper contactMapper;

    @Autowired
    CrmBaseEntityMapper crmBaseEntityMapper;


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
    public void deleteContact(Long id) {
        Contact contact=contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
        contact.getOpportunityList().forEach((opportunity -> opportunity.getContactList().remove(contact)));
        contactRepository.deleteById(id);
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

    public FilteredPageWrapper<ContactDto> getContactFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection) {
        PageRequest pageRequest= PaginationAndFilteringUtil.getPaginationRequest(page,pageSize,sortField,sortDirection);
        List<ContactDto>contactDtoList=new ArrayList<>();
        Page<Contact> resultPage = null;
        int totalResults=0;
        if(!searchFields.getSearchFields().isEmpty() && !searchWord.isEmpty()) {
            List<Specification<Contact>> contactSpecificationList = new ArrayList<>();
            for (String searchField : searchFields.getSearchFields()) {
                contactSpecificationList.add(((root, criteriaQuery, criteriaBuilder) -> {
                    return criteriaBuilder.like(root.get(searchField), "%"+searchWord+"%");
                }));
            }
            Specification<Contact> contactSpecification = contactSpecificationList.stream().reduce(Specification::and).orElse(null);
            resultPage = contactRepository.findAll(contactSpecification, pageRequest);
        }
        else{
            resultPage=contactRepository.findAll(pageRequest);
        }
        if(resultPage!=null){
            contactDtoList=resultPage.getContent().stream().map(contact->contactMapper.toDto((Contact) contact)).collect(Collectors.toList());
            totalResults=resultPage.getTotalPages()*pageSize;
        }
        return new FilteredPageWrapper<>(totalResults,contactDtoList);

    }
}
