package com.crm.Crm.entity;

import com.crm.Crm.enumeration.OpportunityStageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Opportunity extends CrmBaseEntity{
    private String name;
    @Enumerated(EnumType.STRING)
    private OpportunityStageEnum stage;
    private LocalDateTime closeDate;

//    public Opportunity(Long id, Date createDate, Date modifyDate, List<Note> noteList, String name, OpportunityStageEnum stage, LocalDateTime closeDate) {
//        super(id, createDate, modifyDate, noteList);
//        this.name = name;
//        this.stage = stage;
//        this.closeDate = closeDate;
//    }
}
