package com.crm.Crm.resource;

import com.crm.Crm.dto.NotificationDto;
import com.crm.Crm.entity.Notification;
import com.crm.Crm.repository.NotificationRepository;
import com.crm.Crm.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationResource {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/last")
    public ResponseEntity<List<NotificationDto>>getLastNotifications(){
        return new ResponseEntity<>(notificationService.getLastNotifications(), HttpStatus.OK);
    }
}
