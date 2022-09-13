package com.crm.Crm.controller;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CrmBaseEntityController {
    @Autowired
    CrmBaseEntityService crmBaseEntityService;

    @GetMapping("/{id}")
    public ResponseEntity<CrmBaseEntityDto>findById(@PathVariable Long id){
        return new ResponseEntity<>(crmBaseEntityService.getCrmBaseEntityById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        try {
            crmBaseEntityService.deleteCrmBaseEntityById(id);
            return new ResponseEntity( HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("delete error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
