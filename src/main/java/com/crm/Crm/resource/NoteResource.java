package com.crm.Crm.resource;

import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.entity.Note;
import com.crm.Crm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/note")
public class NoteResource {

    @Autowired
    NoteService noteService;

    @GetMapping("/crm-base-entity/{id}")
    public ResponseEntity<List<NoteDto>>getAllCrmBaseEntityNotes(@PathVariable("id")Long id){
        return new ResponseEntity<>(noteService.getNoteListByAccountId(id), HttpStatus.OK);
    }

    @PostMapping("/crm-base-entity/{id}")
    public ResponseEntity<NoteDto>saveNote(@PathVariable("id")Long id,@RequestBody NoteDto noteDto){
        return new ResponseEntity<>(noteService.saveNote(id,noteDto),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<NoteDto>updateNote(@RequestBody NoteDto noteDto){
        return new ResponseEntity<>(noteService.updateNote(noteDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id")Long id){
        noteService.deleteNote(id);
    }
}
