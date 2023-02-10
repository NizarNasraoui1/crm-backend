package com.crm.Crm.service.impl;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.OpportunityMapper;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.repository.OpportunityRepository;
import com.crm.Crm.service.ContactService;
import com.crm.Crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OpportunityMapper opportunityMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private ContactService contactService;

    @Override
    public OpportunityDto saveOpportunity(OpportunityDto opportunityDto) {
        Opportunity opportunity=opportunityMapper.toBo(opportunityDto);
        List<Long>contactIds=opportunity.getContacts().stream().map(Contact::getId).collect(Collectors.toList());
        List<Contact>contactList=contactRepository.findAllByIdIn(contactIds);
        for (Contact contact : contactList) {
            contact.getOpportunities().add(opportunity);
        }
        contactRepository.saveAll(contactList);
        return opportunityMapper.toDto(opportunityRepository.save(opportunity));
    }

    @Override
    public List<OpportunityDto> getAllOpportunities() {
        return opportunityMapper.toDtos(opportunityRepository.findAll());
    }

    @Override
    public List<OpportunityDto> getAllOpportunitiesByStage(OpportunityStageEnum stage) {
        return opportunityMapper.toDtos(opportunityRepository.findAllByStage(stage));
    }

    @Override
    public List<ContactDto> getOpportunityContacts(Long id) {
        Opportunity opportunity= (Opportunity) opportunityRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        return contactMapper.toDtos(opportunity.getContacts());
    }

    @Override
    public void deleteOpportunity(Long id) {
        opportunityRepository.delete(opportunityRepository.findById(id).orElseThrow(()->new EntityNotFoundException("opportunity not found")));

    }

    @Override
    public OpportunityDto updateOpportunity(Long id,OpportunityDto opportunityDto) {
        Opportunity opportunity=opportunityRepository.findById(id).orElseThrow(()->new EntityNotFoundException("opportunity not found"));
        opportunity.setName(opportunityDto.getName());
        opportunity.setStage(opportunityDto.getStage());
        List<Contact>contacts=opportunityDto.getContacts().stream().map((contact)->contactMapper.toBo(contact)).map((contact)->contactRepository.save(contact)).collect(Collectors.toList());
        opportunity.setContacts(contacts);
        return opportunityMapper.toDto(opportunityRepository.save(opportunity));
    }

    @Override
    public List<OpportunityDto> updateOpportunities(List<OpportunityDto> opportunityDtos) {
        opportunityDtos.forEach((opportunityDto -> {
            Opportunity opportunity=opportunityRepository.findById(opportunityDto.getId()).orElseThrow(()->new EntityNotFoundException("opportunity not found"));
            opportunity.setContacts(contactMapper.toBos(opportunityDto.getContacts()));
            opportunity.setStage(opportunityDto.getStage());
            opportunity.setName(opportunityDto.getName());
            opportunity.setCloseDate(opportunityDto.getCloseDate());
            opportunityRepository.save(opportunity);
        }));
        return opportunityMapper.toDtos(opportunityRepository.findAll());
    }
}
