package com.crm.Crm.entity;

import com.crm.Crm.generic.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note extends GenericEntity {
    String content;
}
