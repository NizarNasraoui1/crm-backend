package com.crm.Crm.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ContactDto.class, name = "ContactDto"),
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrmBaseEntityDto{
    private Long id;
    private Date createDate;
    private Date modifyDate;
    List<NoteDto> noteDtoList;
}
