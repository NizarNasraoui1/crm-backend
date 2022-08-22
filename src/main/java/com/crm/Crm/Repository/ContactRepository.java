package com.crm.Crm.Repository;

import com.crm.Crm.generic.GenericRepository;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.GenericPagingAndFilteringRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends GenericRepository<Contact>, GenericPagingAndFilteringRepo<Contact> {
}
