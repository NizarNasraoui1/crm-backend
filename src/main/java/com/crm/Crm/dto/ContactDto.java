package com.crm.Crm.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class ContactDto {
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;

}
