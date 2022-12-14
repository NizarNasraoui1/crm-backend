package com.crm.Crm.service;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.enumeration.OpportunityStageEnum;

import java.util.List;

public interface OpportunityService {
    OpportunityDto saveOpportunity(OpportunityDto opportunityDto);

    List<OpportunityDto> getAllOpportunitiesByStage(OpportunityStageEnum stage);

    List<ContactDto> getOpportunityContacts(Long id);
}
