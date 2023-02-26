package com.crm.Crm.service.impl;

import com.crm.Crm.dto.NotificationDto;
import com.crm.Crm.entity.Notification;
import com.crm.Crm.mapper.NotificationMapper;
import com.crm.Crm.repository.NotificationRepository;
import com.crm.Crm.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    NotificationMapper notificationMapper;
    @Override
    @Cacheable(value = "lastNotifications")
    public List<NotificationDto> getLastNotifications() {
        return notificationMapper.toDtos(notificationRepository.getLastNotifications());
    }
}
