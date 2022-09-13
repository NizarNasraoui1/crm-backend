package com.crm.Crm.generic;

import com.crm.Crm.Util.SpecificationUtil;
import com.crm.Crm.dto.commons.SearchFields;
import org.springframework.data.jpa.domain.Specification;

public class GenericSearchSpecification<T> {
    public Specification<T> getGenericSearchSpecification(String searchWord, SearchFields searchFields){

        return searchFields.getSearchFields().stream().map((searchField)-> SpecificationUtil
                .getSpecificationFromSearchField(searchWord,searchField)).reduce(Specification::or).orElse(null);

    }
}
