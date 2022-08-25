package com.crm.Crm.Util;

import com.crm.Crm.enumeration.SortDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class PaginationAndFilteringUtil {
    public static PageRequest getPaginationRequest(int page, int size, SortDirection sortDirection){
        if(sortDirection.equals("DESC")){
            return PageRequest.of(page,size, Sort.Direction.DESC);
        }
        return PageRequest.of(0,5, Sort.Direction.ASC,"firstName");
    }
}
