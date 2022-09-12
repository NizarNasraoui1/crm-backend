package com.crm.Crm.service.impl;

import com.crm.Crm.Repository.CrmBaseEntityRepo;
import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericMapper;
import com.crm.Crm.generic.GenericSearchSpecification;
import com.crm.Crm.generic.Impl.GenericServiceImpl;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("crmBaseEntityService")
@Primary
public class CrmBaseEntityServiceImpl extends GenericServiceImpl<CrmBaseEntity,CrmBaseEntityDto> implements CrmBaseEntityService {

    @Autowired
    protected CrmBaseEntityMapper mapper;
    @Autowired
    private CrmBaseEntityRepo crmBaseEntityRepo;


    public FilteredPageWrapper<CrmBaseEntityDto> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection) {
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
        FilteredPageWrapper<CrmBaseEntityDto> filteredPageWrapper=new FilteredPageWrapper<>(resultPage.getTotalPages()*pageSize,mapper.toDtos(resultPage.getContent()));
        return new FilteredPageWrapper<>();
    }

    @Override
    public NoteDto getNoteByCrmBaseEntityNote(Long id) {
        return null;
    }
}
