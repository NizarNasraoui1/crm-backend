package com.crm.Crm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticsDto {
    int contactsCount;
    int opportunitiesCount;
    int notesCount;
    int filesCount;

}
