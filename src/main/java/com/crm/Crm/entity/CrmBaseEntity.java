package com.crm.Crm.entity;

import com.crm.Crm.generic.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@MappedSuperclass
public class CrmBaseEntity extends GenericEntity {
    @OneToMany
    List<File> fileList;
    @OneToMany
    List<Note>noteList;
}
