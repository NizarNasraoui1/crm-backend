package com.crm.Crm.service;

import com.crm.Crm.dto.NotificationDto;
import com.crm.Crm.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<NotificationDto> getLastNotifications();
}
