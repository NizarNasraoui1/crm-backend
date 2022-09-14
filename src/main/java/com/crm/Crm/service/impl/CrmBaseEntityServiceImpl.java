package com.crm.Crm.service.impl;

import com.crm.Crm.repository.CrmBaseEntityRepo;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.dto.NoteDto;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import com.crm.Crm.mapper.NoteMapper;
import com.crm.Crm.service.CrmBaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("crmBaseEntityService")
@Primary
@Transactional
public class CrmBaseEntityServiceImpl implements CrmBaseEntityService {

    @Autowired
    protected CrmBaseEntityMapper crmBaseEntityMapper;
    @Autowired
    private ContactMapper contactMapper;
    @Autowired
    private CrmBaseEntityRepo crmBaseEntityRepo;

    @Autowired
    private NoteMapper noteMapper;


    @Override
    public CrmBaseEntityDto getCrmBaseEntityById(Long id) {
        CrmBaseEntity crmBaseEntity= crmBaseEntityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("contact not found"));
        if (crmBaseEntity instanceof Contact){
            return contactMapper.toDto((Contact) crmBaseEntity);
        }
        return crmBaseEntityMapper.toDto(crmBaseEntity);
    }

    @Override
    public void deleteCrmBaseEntityById(Long id) {
        crmBaseEntityRepo.deleteById(id);
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
        CrmBaseEntity crmBaseEntity=crmBaseEntityRepo.findById(id).orElseThrow(()->new ResourceNotFoundException());
        crmBaseEntity.getNoteList().add(noteMapper.toBo(noteDto));
        return crmBaseEntityMapper.toDto(crmBaseEntityRepo.save(crmBaseEntityRepo.save(crmBaseEntity)));
    }


}
