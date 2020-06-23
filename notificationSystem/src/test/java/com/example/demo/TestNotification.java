package com.example.demo;


import com.example.demo.notification.NotificationService;
import com.example.demo.notification.dto.ChannelType;
import com.example.demo.notification.dto.NotificationDTO;
import com.example.demo.notification.impl.NotificationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestNotification {

    @Resource
    private NotificationFactory notificationFactory;

    @Test
    public void testNotificaiton() {
        //MOCK WHEN MAKE ORDER SYSTEM SEND EMAIL NOTIFICATION TO JOHN
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setChannelType(ChannelType.EMAIL.name());
        notificationDTO.setCustomerName("JOHN");
        notificationDTO.setTemplateId("pay");
        notificationDTO.setReceiverEmail("johnxxx@gmail.com");

        Map<String, String> payLoad = new HashMap<>(8);
        payLoad.put("orderId", "19273981723");
        notificationDTO.setPayload(payLoad);

        NotificationService notificationService = notificationFactory.getNotificationService(ChannelType.valueOf(notificationDTO.getChannelType()));
        notificationService.sendNotification(notificationDTO);
    }
}
