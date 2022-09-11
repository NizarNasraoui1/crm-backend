package com.crm.Crm.service.impl;

import com.crm.Crm.Util.PaginationAndFilteringUtil;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericMapper;
import com.crm.Crm.generic.GenericRepository;
import com.crm.Crm.generic.GenericSearchSpecification;
import com.crm.Crm.generic.Impl.GenericServiceImpl;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service("crmBaseEntityService")
public class CrmBaseEntityServiceImpl<T extends GenericEntity,D> extends GenericServiceImpl<T,D> implements CrmBaseEntityService<T,D> {

    @Autowired
    protected GenericMapper<T,D> mapper;
    public FilteredPageWrapper<D> getFilteredPage(String searchWord, SearchFields searchFields, int page, int pageSize, String sortField, String sortDirection) {
        PageRequest pageRequest= PaginationAndFilteringUtil.getPaginationRequest(page,pageSize,sortField,sortDirection);
        GenericSearchSpecification<T> genericSearchSpecification=new GenericSearchSpecification<>();
        Page<T> resultPage;
        if(!searchFields.getSearchFields().isEmpty()){
            Specification<T> filterSpecification= genericSearchSpecification.getGenericSearchSpecification(searchWord, searchFields);
            resultPage=genericRepository.findAll(filterSpecification,pageRequest);
        }
        else{
            resultPage=genericRepository.findAll(pageRequest);
        }
        FilteredPageWrapper<D> filteredPageWrapper=new FilteredPageWrapper<>(resultPage.getTotalPages()*pageSize,mapper.toDtos(resultPage.getContent()));
        return filteredPageWrapper;
    }
}
