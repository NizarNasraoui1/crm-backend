package com.crm.Crm.resource;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CrmBaseEntityResource {
    @Autowired
    CrmBaseEntityService crmBaseEntityService;

    @GetMapping("/{id}")
    public ResponseEntity<CrmBaseEntityDto>findById(@PathVariable Long id){
        return new ResponseEntity<>(crmBaseEntityService.getCrmBaseEntityById(id),HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
//        try {
//            crmBaseEntityService.deleteCrmBaseEntityById(id);
//            return new ResponseEntity( HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity( HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/{id}/note")
    public ResponseEntity<CrmBaseEntityDto>saveNoteToCrmBaseEntity(@PathVariable("id")Long id,@RequestBody NoteDto noteDto){
        return new ResponseEntity<>(crmBaseEntityService.addNoteToCrmBaseEntity(id,noteDto),HttpStatus.OK);
    }

    @GetMapping("/{id}/note")
    public ResponseEntity<List<NoteDto>>getCrmBaseEntityNotes(@PathVariable("id")Long id){
        return new ResponseEntity<>(crmBaseEntityService.getCrmBaseEntityNotes(id),HttpStatus.OK);
    }


}
