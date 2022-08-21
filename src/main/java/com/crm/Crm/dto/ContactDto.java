package com.crm.Crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    Long id;
    String firstName;
    String lastName;
    double phoneNumber;
    String address;
    String email;
}
