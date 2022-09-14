package com.crm.Crm.service;

import com.crm.Crm.dto.NoteDto;

import java.util.List;

public interface NoteService {
    public List<NoteDto> getNoteListByAccountId(Long id);
    public NoteDto saveNote(Long id,NoteDto noteDto);

    public NoteDto updateNote(NoteDto noteDto);
}
