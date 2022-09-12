package com.crm.Crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GenericEntityDto {

    private Long id;
    Date createDate;

    private Date modifyDate;


}