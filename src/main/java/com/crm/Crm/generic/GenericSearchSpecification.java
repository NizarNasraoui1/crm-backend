package com.crm.Crm.generic;

import com.crm.Crm.Util.SpecificationUtil;
import com.crm.Crm.dto.SearchFields;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenericSearchSpecification<T> {
    public Specification<T> getGenericSearchSpecification(String searchWord, SearchFields searchFields){
        return searchFields.getSearchFields().stream().map((searchField)-> SpecificationUtil
                .getSpecificationFromSearchField(searchWord,searchField)).reduce(Specification::or).orElse(null);

    }
}
