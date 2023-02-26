package com.crm.Crm.service;

import com.crm.Crm.dto.NoteDto;

import java.util.List;

public interface NoteService {
    List<NoteDto> getNoteListByAccountId(Long id);
    NoteDto saveNote(Long id,NoteDto noteDto);

    NoteDto updateNote(Long id,NoteDto noteDto);

    void deleteNote(Long id);

    int countNotes();
}
