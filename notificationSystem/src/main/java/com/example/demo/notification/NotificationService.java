package com.example.demo.notification;


import com.example.demo.notification.dto.NotificaitonQuery;
import com.example.demo.notification.dto.NotificationDTO;

public interface NotificationService {

    void sendNotification(NotificationDTO notification);

    NotificationDTO queryNotification(NotificaitonQuery notificaitonQuery);
}
