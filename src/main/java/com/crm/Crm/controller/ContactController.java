package com.crm.Crm.controller;

import com.crm.Crm.generic.GenericController;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController extends GenericController<Contact, ContactDto> {
}
