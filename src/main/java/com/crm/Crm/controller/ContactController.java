package com.crm.Crm.controller;

import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.generic.GenericController;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController extends GenericController<Contact, ContactDto> {
    @Autowired
    ContactService contactService;
    @GetMapping("/filteredContact")
    public ResponseEntity<FilteredPageWrapper<ContactDto>> getFilteredContactPage(
            @RequestParam(name="page",required = false,defaultValue = "0") int page,
            @RequestParam(name="rows",required = false,defaultValue = "10")int rows,
            @RequestParam(name="searchWord",required=true)String searchWord,
            @RequestParam(name="sortField",required = false,defaultValue = "id")String sortField)
    {
        return new ResponseEntity(contactService.getContactFilteredPage(page,rows,searchWord, sortField), HttpStatus.OK);
    }
}
