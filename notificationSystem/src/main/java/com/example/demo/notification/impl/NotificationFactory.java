package com.example.demo.notification.impl;

import com.example.demo.notification.NotificationService;
import com.example.demo.notification.dto.ChannelType;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.example.demo.notification.dto.ChannelType.EMAIL;
import static com.example.demo.notification.dto.ChannelType.IN_APP;
import static com.example.demo.notification.dto.ChannelType.SMS;

@Component
public class NotificationFactory {

    @Resource
    private EmailNotificaitonServiceImpl emailNotificaitonService;
    @Resource
    private SMSNotificationServiceImpl smsNotificationService;
    @Resource
    private InAppNotificationServiceImpl inAppNotificationService;

    private Map<ChannelType, NotificationService> notificationServiceMap = new HashMap<>(5);


    @PostConstruct
    public void init(){
        notificationServiceMap.put(SMS, emailNotificaitonService);
        notificationServiceMap.put(EMAIL, emailNotificaitonService);
        notificationServiceMap.put(IN_APP, emailNotificaitonService);
    }

    private static final String SUFFIX = "NotificationService";

    public NotificationService getNotificationService(ChannelType channelType){
        return notificationServiceMap.get(channelType);
    }
}
