package com.crm.Crm.dto;

import com.crm.Crm.enumeration.OpportunityStageEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
public class OpportunityDto extends CrmBaseEntityDto{
    private String name;
    private OpportunityStageEnum stage;
    private LocalDateTime closeDate;
    private List<ContactDto> contactList;

    public OpportunityDto(Long id, Date createDate, Date modifyDate, List<NoteDto> noteList, String name, OpportunityStageEnum stage, LocalDateTime closeDate, List<ContactDto> contactList) {
        super(id, createDate, modifyDate, noteList);
        this.name = name;
        this.stage = stage;
        this.closeDate = closeDate;
        this.contactList = contactList;
    }
}
