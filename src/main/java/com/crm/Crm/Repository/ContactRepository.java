package com.crm.Crm.Repository;

import com.crm.Crm.Repository.Generic.GenericRepository;
import com.crm.Crm.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends GenericRepository<Contact> {
}
