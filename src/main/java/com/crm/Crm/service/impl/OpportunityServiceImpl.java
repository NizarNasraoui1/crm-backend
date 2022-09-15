package com.crm.Crm.service.impl;

import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import com.crm.Crm.mapper.OpportunityMapper;
import com.crm.Crm.repository.OpportunityRepository;
import com.crm.Crm.service.OpportunityService;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    OpportunityMapper opportunityMapper;

    @Override
    public OpportunityDto saveOpportunity(OpportunityDto opportunityDto) {
        return opportunityMapper.toDto(opportunityRepository.save(opportunityMapper.toBo(opportunityDto)));
    }

    @Override
    public List<OpportunityDto> getAllOpportunitiesByStage(OpportunityStageEnum stage) {
        return opportunityMapper.toDtos(opportunityRepository.findAllByStage(stage));
    }
}
