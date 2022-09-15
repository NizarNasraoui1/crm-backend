package com.crm.Crm.mapper;

import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.entity.Opportunity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpportunityMapper extends GenericMapper<Opportunity, OpportunityDto> {
}
