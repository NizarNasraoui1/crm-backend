package com.crm.Crm.controller;

import com.crm.Crm.Exception.SearchFieldNotFoundException;
import com.crm.Crm.dto.SearchConfiguration;
import com.crm.Crm.dto.SearchFields;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import com.crm.Crm.generic.GenericController;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/contact")
public class ContactController extends CrmBaseEntityController<Contact, ContactDto> {
    @Autowired
    ContactService contactService;
    @PutMapping("/details/{id}")
    public ResponseEntity<ContactDto> updateContactDetails(@PathVariable("id")Long id,@RequestBody ContactDto contactDto){
        return new ResponseEntity<>(contactService.updateContactDetails(id,contactDto),HttpStatus.OK);
    }
    @GetMapping("/searchParams")
    public ResponseEntity<SearchConfiguration> getSearchParams() throws ClassNotFoundException {
        return new ResponseEntity<>(this.contactService.getSearchParams(),HttpStatus.OK);
    }
//    @PostMapping("/filteredContactsPage")
//    public ResponseEntity<FilteredPageWrapper<ContactDto>> getFilteredContactPage(
//            @RequestParam(name="page",required = false,defaultValue = "0") int page,
//            @RequestParam(name="rows",required = false,defaultValue = "10")int rows,
//            @RequestParam(name="searchWord",required=true)String searchWord,
//            @RequestParam(name="sortField",required = false,defaultValue = "id")String sortField,
//            @RequestBody SearchFields searchFields)
//    {
//        try{
//            return new ResponseEntity(contactService.getContactFilteredPage(page,rows,searchWord,searchFields, sortField), HttpStatus.OK);
//        } catch (SearchFieldNotFoundException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
