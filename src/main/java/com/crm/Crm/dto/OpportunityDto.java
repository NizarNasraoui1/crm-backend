package com.crm.Crm.dto;

import com.crm.Crm.enumeration.OpportunityStageEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@Data
public class OpportunityDto extends CrmBaseEntityDto{
    private String name;
    private OpportunityStageEnum stage;
    private LocalDateTime closeDate;
}
