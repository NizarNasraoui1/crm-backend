package com.crm.Crm.service.impl;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.service.ContactService;
import com.crm.Crm.generic.Impl.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl extends GenericServiceImpl<Contact, ContactDto> implements ContactService {
}
