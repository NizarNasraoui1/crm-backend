package com.crm.Crm.mapper;

import com.crm.Crm.dto.NotificationDto;
import com.crm.Crm.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper extends GenericMapper<Notification, NotificationDto> {
}
