package com.crm.Crm.Repository.Impl;

import com.crm.Crm.Repository.ContactSearchCriteria;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.generic.wrapper.FilteredPageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContactSearchCriteriaImpl implements ContactSearchCriteria {
    @Autowired
    EntityManager entityManager;
    @Override
    public List<Contact> getContactFilteredPage(int page, int rows, String searchWord,String sortField) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact>cq=cb.createQuery(Contact.class);
        Root<Contact>root=cq.from(Contact.class);
        List<Predicate>predicates=new ArrayList<>();
        predicates.add(cb.like(root.get("firstName"),"%"+searchWord));
        predicates.add(cb.like(root.get("lastName"),"%"+searchWord));
        Predicate predicate=cb.or(predicates.toArray(new Predicate[0]));
        cq.where(predicate);
        TypedQuery<Contact>typedQuery=entityManager.createQuery(cq);
        typedQuery.setFirstResult(page*rows);
        typedQuery.setMaxResults(rows);
        Sort sort= Sort.by(Sort.Direction.ASC,sortField);
        Pageable pageable= PageRequest.of(page,rows,sort);
        return typedQuery.getResultList();
    }
}
