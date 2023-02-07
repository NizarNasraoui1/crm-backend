package com.crm.Crm.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Data
public class NotificationDto {

    private Long id;

    private String title;

    private String message;

    private Date createDate;

    private Boolean seen;
}
