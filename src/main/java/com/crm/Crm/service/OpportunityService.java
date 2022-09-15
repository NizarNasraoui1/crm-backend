package com.crm.Crm.service;

import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import javafx.stage.Stage;

import java.util.List;

public interface OpportunityService {
    public OpportunityDto saveOpportunity(OpportunityDto opportunityDto);

    public List<OpportunityDto> getAllOpportunitiesByStage(OpportunityStageEnum stage);
}
