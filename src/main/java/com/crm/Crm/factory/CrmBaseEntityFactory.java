package com.crm.Crm.factory;

import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.entity.CrmBaseEntity;

public interface CrmBaseEntityFactory {
    CrmBaseEntity getInstance();
    CrmBaseEntityDto getDtoInstance();
}
