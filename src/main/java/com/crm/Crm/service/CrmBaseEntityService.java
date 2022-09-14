package com.crm.Crm.service;

import com.crm.Crm.dto.*;
import com.crm.Crm.dto.commons.SearchConfiguration;

import java.util.List;

public interface CrmBaseEntityService{

    CrmBaseEntityDto getCrmBaseEntityById(Long id);

    public void deleteCrmBaseEntityById(Long id);

    SearchConfiguration getSearchParams();
    NoteDto getCrmBaseEntityNoteById(Long id);

    CrmBaseEntityDto addNoteToCrmBaseEntity(Long id,NoteDto noteDto);

}
