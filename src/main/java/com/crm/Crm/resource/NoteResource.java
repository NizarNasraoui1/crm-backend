package com.crm.Crm.resource;

import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.entity.Note;
import com.crm.Crm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/note")
public class NoteResource {

    @Autowired
    NoteService noteService;

    @GetMapping("/crmBaseEntity/{id}")
    public ResponseEntity<List<NoteDto>>getAllCrmBaseEntityNotes(@PathVariable("id")Long id){
        return new ResponseEntity<>(noteService.getNoteListByAccountId(id), HttpStatus.OK);
    }
}
