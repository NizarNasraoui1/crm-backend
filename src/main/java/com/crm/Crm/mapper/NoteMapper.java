package com.crm.Crm.mapper;

import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.entity.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper extends GenericMapper<Note, NoteDto> {

}
