package com.crm.Crm.resource;

import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import com.crm.Crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/opportunity")
public class OpportunityResource {
    @Autowired
    OpportunityService opportunityService;

    @PostMapping
    public ResponseEntity<OpportunityDto> saveOpportunity(@RequestBody OpportunityDto opportunityDto){
        return new ResponseEntity<>(opportunityService.saveOpportunity(opportunityDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OpportunityDto>> getAllOpportunitiesByStage(@RequestParam(value = "stage",required = true) OpportunityStageEnum stage){
        return new ResponseEntity<>(opportunityService.getAllOpportunitiesByStage(stage),HttpStatus.OK);
    }
}
