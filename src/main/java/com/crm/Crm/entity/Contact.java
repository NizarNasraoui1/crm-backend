package com.crm.Crm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Contact extends CrmBaseEntity {

    String firstName;
    String lastName;
    String address;
    String email;


    public Contact(List<File> fileList, List<Note> noteList) {
        super(fileList, noteList);
    }
    public Contact() {
        super(new ArrayList<>(), new ArrayList<>());
    }
}
