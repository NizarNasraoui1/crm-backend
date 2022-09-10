package com.crm.Crm.Util;

import com.crm.Crm.enumeration.SortDirection;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Objects;

public class PaginationAndFilteringUtil {
    public static PageRequest getPaginationRequest(int page, int size,String sortField, SortDirection sortDirection){
        if(sortField!=null){
            if(sortDirection.equals("ASC")){
                return PageRequest.of(page,size,Sort.Direction.ASC,sortField);
            }
            else{
                return PageRequest.of(page,size,Sort.Direction.DESC,sortField);
            }
        }
        return PageRequest.of(page,size, Sort.Direction.DESC,"modifyDate");
    }
}
