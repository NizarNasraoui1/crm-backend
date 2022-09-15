package com.crm.Crm.service.impl;

import com.crm.Crm.entity.Note;
import com.crm.Crm.repository.CrmBaseEntityRepository;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import com.crm.Crm.mapper.NoteMapper;
import com.crm.Crm.repository.NoteRepository;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("crmBaseEntityService")
@Primary
@Transactional
public class CrmBaseEntityServiceImpl implements CrmBaseEntityService {

    @Autowired
    protected CrmBaseEntityMapper crmBaseEntityMapper;
    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CrmBaseEntityRepository crmBaseEntityRepository;

    @Autowired
    private NoteMapper noteMapper;


    @Override
    public CrmBaseEntityDto getCrmBaseEntityById(Long id) {
        CrmBaseEntity crmBaseEntity= crmBaseEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found"));
        if (crmBaseEntity instanceof Contact){
            return contactMapper.toDto((Contact) crmBaseEntity);
        }
        return crmBaseEntityMapper.toDto(crmBaseEntity);
    }

    @Override
    public void deleteCrmBaseEntityById(Long id) {
        crmBaseEntityRepository.deleteById(id);
    }

    @Override
    public SearchConfiguration getSearchParams() {
        return null;
    }

    @Override
    public NoteDto getCrmBaseEntityNoteById(Long id) {
        return null;
    }

    @Override
    public CrmBaseEntityDto addNoteToCrmBaseEntity(Long id,NoteDto noteDto) {
        Note note=noteMapper.toBo(noteDto);
        CrmBaseEntity crmBaseEntity= crmBaseEntityRepository.findById(id).orElseThrow(()->new ResourceNotFoundException());
        crmBaseEntity.getNoteList().add(note);
        note.setCrmBaseEntity(crmBaseEntity);
        return crmBaseEntityMapper.toDto(crmBaseEntityRepository.save(crmBaseEntityRepository.save(crmBaseEntity)));
    }

    @Override
    public List<NoteDto> getCrmBaseEntityNotes(Long id) {
        return noteMapper.toDtos(noteRepository.findAllByCrmBaseEntityOrderByModifyDate(id));
    }


}
