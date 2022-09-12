package com.crm.Crm.mapper;

import com.crm.Crm.entity.Contact;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.generic.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends GenericMapper<Contact, ContactDto>{
}
