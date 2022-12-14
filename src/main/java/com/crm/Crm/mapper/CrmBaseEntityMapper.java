package com.crm.Crm.mapper;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.entity.CrmBaseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CrmBaseEntityMapper extends GenericMapper<CrmBaseEntity, CrmBaseEntityDto> {
}
