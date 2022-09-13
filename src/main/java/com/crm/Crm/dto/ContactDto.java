package com.crm.Crm.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class ContactDto extends CrmBaseEntityDto{
    Long id;
    String firstName;
    String lastName;
    String address;
    String email;

    public ContactDto(Long id, Date createDate, Date modifyDate, List<NoteDto> noteDtoList, Long id1, String firstName, String lastName, String address, String email) {
        super(id, createDate, modifyDate, noteDtoList);
        this.id = id1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
}
