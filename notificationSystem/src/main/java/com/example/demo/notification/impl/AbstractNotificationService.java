package com.example.demo.notification.impl;


import com.example.demo.notification.NotificationService;
import com.example.demo.notification.TemplateService;
import com.example.demo.notification.dto.MessageDO;
import com.example.demo.notification.dto.NotificaitonQuery;
import com.example.demo.notification.dto.NotificationDTO;
import org.junit.Assert;

import javax.annotation.Resource;

public abstract class AbstractNotificationService implements NotificationService {

    @Resource
    public TemplateService templateService;


    @Override
    public void sendNotification(NotificationDTO notification) {
        Assert.assertTrue(validate(notification));
        MessageDO message = buildMessage(notification);
        sendMessage(message);
        recordMessage(message);
    }

    abstract boolean validate(NotificationDTO notification);

    abstract MessageDO buildMessage(NotificationDTO notification);

    abstract void sendMessage(MessageDO message);

    private void recordMessage(MessageDO message) {
        //MOCK TO DB
        System.out.println("record the message to DB");
    }

    @Override
    public NotificationDTO queryNotification(NotificaitonQuery notificaitonQuery) {
        System.out.println("MOCK query from cache");
        return null;
    }

}
