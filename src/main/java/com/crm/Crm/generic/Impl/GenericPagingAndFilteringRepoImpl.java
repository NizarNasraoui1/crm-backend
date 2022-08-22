package com.crm.Crm.generic.Impl;

import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericPagingAndFilteringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
public class GenericPagingAndFilteringRepoImpl<T extends GenericEntity> implements GenericPagingAndFilteringRepo<T> {
    @Autowired
    EntityManager entityManager;
    //@Override
    public List<T> getFilteredPage(int page, int rows,String searchWord, List<String> searchFields, String sortField,Class entityClass) {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq=cb.createQuery(entityClass);
        Root<T> root=cq.from(entityClass);
        List<Predicate>predicates=new ArrayList<>();
        searchFields.stream().forEach((searchField)->{
            predicates.add(cb.like(root.get(searchField),"%"+searchWord));
        });
        Predicate predicate=cb.or(predicates.toArray(new Predicate[0]));
        cq.where(predicate);
        TypedQuery<T> typedQuery=entityManager.createQuery(cq);
        typedQuery.setFirstResult(page*rows);
        typedQuery.setMaxResults(rows);
        Sort sort= Sort.by(Sort.Direction.ASC,sortField);
        Pageable pageable= PageRequest.of(page,rows,sort);
        return typedQuery.getResultList();
    }
}
