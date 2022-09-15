package com.crm.Crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact extends CrmBaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;

//    public Contact(Long id, Date createDate, Date modifyDate, List<Note> noteList, String firstName, String lastName, String address, String email) {
//        super(id, createDate, modifyDate, noteList);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.address = address;
//        this.email = email;
//    }
}
