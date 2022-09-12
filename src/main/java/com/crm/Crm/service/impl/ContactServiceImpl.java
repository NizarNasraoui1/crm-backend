package com.crm.Crm.service.impl;

import com.crm.Crm.Exception.SearchFieldNotFoundException;
import com.crm.Crm.Repository.ContactRepository;
import com.crm.Crm.Repository.ContactSearchCriteria;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.ParamDto;
import com.crm.Crm.dto.SearchConfiguration;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.enumeration.ContactSearchFields;
import com.crm.Crm.enumeration.ContactSortFields;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.service.ContactService;
import com.crm.Crm.generic.Impl.GenericServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl extends CrmBaseEntityServiceImpl implements ContactService {
    @Autowired
    ContactSearchCriteria contactSearchCriteria;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactMapper contactMapper;
    public FilteredPageWrapper<ContactDto>getContactFilteredPage(int page, int rows, String searchWord, SearchFields searchFields,String sortField) throws SearchFieldNotFoundException {
            List<Field> contactfields=Arrays.asList(Contact.class.getDeclaredFields());
            for(Field field:contactfields){
                if(!contactfields.contains(field)){
                    throw new SearchFieldNotFoundException("invalid search fields");
                }
            }
            List<? extends CrmBaseEntity> crmBaseEntities=contactRepository.getFilteredPage( page,  rows, "ali", searchFields.getSearchFields(), sortField,Contact.class);
    List<ContactDto> contactDtoList=contactMapper.toDtos(new ArrayList<>());
        return new FilteredPageWrapper<ContactDto>(contactDtoList.size(),contactDtoList);
    }

    @Override
    public ContactDto updateContactDetails(Long id, ContactDto contactDto) {
//        Contact updateContact= contactRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
//        updateContact.setFirstName(contactDto.getFirstName());
//        updateContact.setLastName(contactDto.getLastName());
//        updateContact.setAddress(contactDto.getAddress());
//        updateContact.setEmail(contactDto.getEmail());
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
