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
public class Contact extends CrmBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String firstName;
    String lastName;
    String address;
    String email;

    public Contact(Long id, Date createDate, Date modifyDate, List<File> fileList, List<Note> noteList, Long id1, String firstName, String lastName, String address, String email) {
        super(id, createDate, modifyDate, fileList, noteList);
        this.id = id1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
}
