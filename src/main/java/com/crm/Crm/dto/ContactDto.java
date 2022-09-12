package com.crm.Crm.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ContactDto extends CrmBaseEntityDto{
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;

}
