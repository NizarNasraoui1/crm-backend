package com.crm.Crm.event;

import com.crm.Crm.entity.Contact;
import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.entity.Notification;
import com.crm.Crm.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CrmBaseEntityCreatedEventListener implements ApplicationListener<CrmBaseEntityCreatedEvent> {
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public void onApplicationEvent(CrmBaseEntityCreatedEvent crmBaseEntityCreatedEvent) {
        CrmBaseEntity crmBaseEntity=crmBaseEntityCreatedEvent.getCrmBaseEntity();
        if(crmBaseEntity instanceof Contact){
            Notification notification=Notification.builder().title("New Contact Created").message("New Contact Created with name: "+((Contact) crmBaseEntity).getFirstName()).build();
            notificationRepository.save(notification);
        }
    }
}
