package com.crm.Crm.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String path;
    @ManyToOne
    @JoinColumn(name="file_id",referencedColumnName = "id")
    CrmBaseEntity crmBaseEntity;
}
