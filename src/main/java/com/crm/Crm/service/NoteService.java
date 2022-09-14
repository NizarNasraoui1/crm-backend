package com.crm.Crm.service;

import com.crm.Crm.dto.NoteDto;

import java.util.List;

public interface NoteService {
    public List<NoteDto> getNoteListByAccountId(Long id);
}
