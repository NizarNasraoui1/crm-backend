package com.crm.Crm.batch;

import com.crm.Crm.entity.Contact;
import org.springframework.batch.item.ItemProcessor;

public class ContactProcessor implements ItemProcessor<Contact,Contact> {

    @Override
    public Contact process(Contact contact) throws Exception {
        return contact;
    }
}
