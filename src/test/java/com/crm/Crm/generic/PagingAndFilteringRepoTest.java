package com.crm.Crm.generic;

import com.crm.Crm.Repository.ContactRepository;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.Impl.PagingAndFilteringRepoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

public class PagingAndFilteringRepoTest {

    public void getFilteredPage() {
//        List<String> searchFields= Arrays.asList("firstName","lastName");
//        PagingAndFilteringRepo<Contact> repo=new PagingAndFilteringRepoImpl<>();
//        List<Contact>result=repo.getFilteredPage(0,10,"ali",searchFields,"id");
//        Assertions.assertNotNull(result);
    }
}