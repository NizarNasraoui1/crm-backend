package com.crm.Crm.entity;

import com.crm.Crm.generic.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CrmBaseEntity extends GenericEntity {
    @OneToMany
    private List<File> fileList;
    @OneToMany
    private List<Note>noteList;
}
