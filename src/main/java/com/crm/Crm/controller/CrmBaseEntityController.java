package com.crm.Crm.controller;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericController;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericMapper;
import com.crm.Crm.generic.GenericService;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class CrmBaseEntityController extends GenericController<CrmBaseEntity, CrmBaseEntityDto> {
    @Autowired
    CrmBaseEntityService crmBaseEntityService;


    @PostMapping("/filter")
    public ResponseEntity<FilteredPageWrapper<CrmBaseEntityDto>> filter(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                                         @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                                         @RequestParam(value = "sortDirection",required = false,defaultValue = "ASC") String sortDirection,
                                                         @RequestParam(value = "sortField",required = false)String sortField,
                                                         @RequestParam(value = "searchWord",required = false,defaultValue = "")String searchWord,
                                                         @RequestBody SearchFields searchFields){
        return new ResponseEntity<>(this.crmBaseEntityService.getFilteredPage(searchWord,searchFields,page, pageSize,sortField, sortDirection), HttpStatus.OK);

    }
}
