package com.crm.Crm.entity;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.mapper.ContactMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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



    @ManyToMany(mappedBy = "contacts")
    List<Opportunity> opportunities=new ArrayList<>();





}
