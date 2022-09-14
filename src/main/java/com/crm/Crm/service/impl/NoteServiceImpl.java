package com.crm.Crm.service.impl;

import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.mapper.NoteMapper;
import com.crm.Crm.repository.NoteRepository;
import com.crm.Crm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;
    @Override
    public List<NoteDto> getNoteListByAccountId(Long id) {
        return noteMapper.toDtos(noteRepository.findAllByCrmBaseEntityId(id));
    }
}
