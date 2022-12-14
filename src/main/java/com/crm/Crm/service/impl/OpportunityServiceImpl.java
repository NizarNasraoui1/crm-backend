package com.crm.Crm.service.impl;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.OpportunityMapper;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.repository.OpportunityRepository;
import com.crm.Crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    OpportunityMapper opportunityMapper;

    @Autowired
    ContactMapper contactMapper;

    @Override
    public OpportunityDto saveOpportunity(OpportunityDto opportunityDto) {
        return opportunityMapper.toDto(opportunityRepository.save(opportunityMapper.toBo(opportunityDto)));
    }

    @Override
    public List<OpportunityDto> getAllOpportunitiesByStage(OpportunityStageEnum stage) {
        return opportunityMapper.toDtos(opportunityRepository.findAllByStage(stage));
    }

    @Override
    public List<ContactDto> getOpportunityContacts(Long id) {
        Opportunity opportunity= (Opportunity) opportunityRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        return contactMapper.toDtos(opportunity.getContactList());
    }
}
