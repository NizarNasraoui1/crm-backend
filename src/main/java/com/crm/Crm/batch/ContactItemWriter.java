package com.crm.Crm.batch;

import com.crm.Crm.entity.Contact;
import com.crm.Crm.repository.ContactRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactItemWriter extends RepositoryItemWriter<Contact> {
    private final ContactRepository contactRepository;

    public ContactItemWriter(ContactRepository contactRepository){
        super();
        this.contactRepository=contactRepository;
        this.setRepository(contactRepository);
        this.setMethodName("save");
    }

}
