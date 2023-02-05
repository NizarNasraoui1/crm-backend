package com.crm.Crm.entity;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.dto.CrmBaseEntityDto;
import com.crm.Crm.mapper.CrmBaseEntityMapper;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CrmBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    @OneToMany(mappedBy = "crmBaseEntity",cascade = CascadeType.ALL)
    private List<File> fileList;
    @OneToMany(mappedBy = "crmBaseEntity",cascade = CascadeType.ALL)
    private List<Note>noteList;

    @Autowired
    @Transient
    CrmBaseEntityMapper crmBaseEntityMapper;
    public CrmBaseEntityDto toDto(CrmBaseEntity crmBaseEntity){
        return crmBaseEntityMapper.toDto(crmBaseEntity);
    }




}
