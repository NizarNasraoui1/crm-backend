package com.crm.Crm.factory;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactFactory implements CrmBaseEntityFactory{
    @Autowired
    ContactMapper contactMapper;

    @Override
    public Contact getInstance() {
        return null;
    }

    @Override
    public ContactDto getDtoInstance() {
        return null;
    }
}
