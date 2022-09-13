package com.crm.Crm.service.impl;

import com.crm.Crm.Repository.CrmBaseEntityRepo;
import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.dto.commons.SearchFields;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericSearchSpecification;
import com.crm.Crm.dto.commons.FilteredPageWrapper;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("crmBaseEntityService")
@Primary
public class CrmBaseEntityServiceImpl implements CrmBaseEntityService {

    @Autowired
    protected CrmBaseEntityMapper crmBaseEntityMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private CrmBaseEntityRepo crmBaseEntityRepo;


    @Override
    public CrmBaseEntityDto getCrmBaseEntityById(Long id) {
        CrmBaseEntity crmBaseEntity= crmBaseEntityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found"));
        if (crmBaseEntity instanceof Contact){
            return contactMapper.toDto((Contact) crmBaseEntity);
        }
        return crmBaseEntityMapper.toDto(crmBaseEntity);
    }

    @Override
    public void deleteCrmBaseEntityById(Long id) {
        crmBaseEntityRepo.deleteById(id);
    }

    @Override
    public SearchConfiguration getSearchParams() {
        return null;
    }

    public FilteredPageWrapper<CrmBaseEntityDto> getCrmBaseEntityFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection) {
        PageRequest pageRequest= PaginationAndFilteringUtil.getPaginationRequest(page,pageSize,sortField,sortDirection);
        GenericSearchSpecification<CrmBaseEntity> genericSearchSpecification=new GenericSearchSpecification<>();
        Page<CrmBaseEntity> resultPage;
        if(!searchFields.getSearchFields().isEmpty()){
            Specification<CrmBaseEntity> filterSpecification= genericSearchSpecification.getGenericSearchSpecification(searchWord, searchFields);
            resultPage=crmBaseEntityRepo.findAll(filterSpecification,pageRequest);
        }
        else{
            resultPage=crmBaseEntityRepo.findAll(pageRequest);
        }
        return new FilteredPageWrapper<>(resultPage.getTotalPages()*pageSize,crmBaseEntityMapper.toDtos(resultPage.getContent()));
    }

    @Override
    public NoteDto getNoteByCrmBaseEntityNote(Long id) {
        return null;
    }
}
