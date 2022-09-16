package com.crm.Crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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

    @ManyToMany(mappedBy = "contactList")
    List<Opportunity> opportunityList;


}
