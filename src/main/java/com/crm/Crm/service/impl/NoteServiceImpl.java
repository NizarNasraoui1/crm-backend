package com.crm.Crm.service.impl;

import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.entity.Note;
import com.crm.Crm.mapper.NoteMapper;
import com.crm.Crm.repository.CrmBaseEntityRepository;
import com.crm.Crm.repository.NoteRepository;
import com.crm.Crm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private CrmBaseEntityRepository crmBaseEntityRepository;
    @Override
    public List<NoteDto> getNoteListByAccountId(Long id) {
        return noteMapper.toDtos(noteRepository.findAllByCrmBaseEntityId(id));
    }

    @Override
    public NoteDto saveNote(Long id, NoteDto noteDto) {
        CrmBaseEntity crmBaseEntity=crmBaseEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
        Note note=noteMapper.toBo(noteDto);
        note.setCrmBaseEntity(crmBaseEntity);
        crmBaseEntity.getNoteList().add(note);
        Note savedNote=noteRepository.save(noteMapper.toBo(noteDto));
        noteRepository.countNotes();
        return noteMapper.toDto(savedNote);
    }

    @Override
    public NoteDto updateNote(Long id,NoteDto noteDto) {
        Note note=noteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
        note.setContent(noteDto.getContent());
        note.setTitle(noteDto.getTitle());
        return noteMapper.toDto(noteRepository.save(note));
    }

    @Override
    public void deleteNote(Long id) {
        this.noteRepository.deleteById(id);
        noteRepository.countNotes();
    }

    @Override
    @Cacheable(value="noteCount")
    public int countNotes() {
        return noteRepository.countNotes();
    }
}
