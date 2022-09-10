package com.crm.Crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class SearchConfiguration {
    List<ParamDto>sortFields;
    List<ParamDto>searchFields;

    public SearchConfiguration(){
        this.searchFields=new ArrayList<>();
        this.sortFields=new ArrayList<>();
    }
}
