package com.crm.Crm.entity;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.OpportunityDto;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.mapper.OpportunityMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Opportunity extends CrmBaseEntity{
    private String name;
    @Enumerated(EnumType.STRING)
    private OpportunityStageEnum stage;
    private LocalDateTime closeDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="opportunity_contact",joinColumns = @JoinColumn(name = "opportunity_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="contact_id",referencedColumnName = "id"))
    @JsonIgnore
    List<Contact> contacts;

    public Opportunity() {
        this.contacts=new ArrayList<>();
    }




    //    public Opportunity(Long id, Date createDate, Date modifyDate, List<Note> noteList, String name, OpportunityStageEnum stage, LocalDateTime closeDate) {
//        super(id, createDate, modifyDate, noteList);
//        this.name = name;
//        this.stage = stage;
//        this.closeDate = closeDate;
//    }
}
