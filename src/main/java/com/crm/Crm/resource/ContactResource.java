package com.crm.Crm.resource;

import com.crm.Crm.dto.DynamicSearchDto;
import com.crm.Crm.dto.commons.SearchConfiguration;
import com.crm.Crm.dto.commons.SearchFields;
import com.crm.Crm.dto.commons.FilteredPageWrapper;
import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contact")
public class ContactResource extends CrmBaseEntityResource {
    @Autowired
    ContactService contactService;

    @GetMapping("/{id}/has-opportunity")
    public ResponseEntity<Boolean>hasOpportunity(@PathVariable("id")Long id){
        return ResponseEntity.ok(contactService.hasOpportunity(id));
    }

    @PostMapping
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto entityDto) {
        try {
            return new ResponseEntity(contactService.saveContact(entityDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("save contact error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/details")
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto entityDto) {
        try {
            return new ResponseEntity(contactService.saveContact(entityDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("update contact error!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id")Long id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/filter")
    public ResponseEntity<FilteredPageWrapper<ContactDto>> filter(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                                                                        @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                                                                        @RequestParam(value = "sortDirection",required = false,defaultValue = "ASC") String sortDirection,
                                                                        @RequestParam(value = "sortField",required = false)String sortField,
                                                                        @RequestParam(value = "searchWord",required = false,defaultValue = "")String searchWord,
                                                                        @RequestBody SearchFields searchFields){
        return new ResponseEntity<>(this.contactService.getContactFilteredPage(searchWord,searchFields,page, pageSize,sortField, sortDirection), HttpStatus.OK);

    }


    @PutMapping("/details/{id}")
    public ResponseEntity<ContactDto> updateContactDetails(@PathVariable("id")Long id,@RequestBody ContactDto contactDto){
        return new ResponseEntity<>(contactService.updateContactDetails(id,contactDto),HttpStatus.OK);
    }
    @GetMapping("/search-params")
    public ResponseEntity<SearchConfiguration> getSearchParams() throws ClassNotFoundException {
        return new ResponseEntity<>(this.contactService.getSearchParams(),HttpStatus.OK);
    }
    @GetMapping("/dynamic-search")
    public ResponseEntity<List<DynamicSearchDto>> getContactDynamicallyByFirstName(@RequestParam(value = "word-search-param",required = true)String wordSearchParam){
        return new ResponseEntity<>(contactService.findContactDynamically(wordSearchParam),HttpStatus.OK);
    }
}
