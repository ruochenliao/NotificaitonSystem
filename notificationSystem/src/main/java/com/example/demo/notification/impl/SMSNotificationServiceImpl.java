package com.example.demo.notification.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.notification.dto.MessageDO;
import com.example.demo.notification.dto.NotificaitonQuery;
import com.example.demo.notification.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class SMSNotificationServiceImpl extends AbstractNotificationService {
    @Override
    public boolean validate(NotificationDTO notification) {
        System.out.println("validate SMS");
        return "SMS".equalsIgnoreCase(notification.getChannelType());
    }

    @Override
    public MessageDO buildMessage(NotificationDTO notification) {
        //build email message
        MessageDO messageDO = new MessageDO();
        messageDO.setChannelType(notification.getChannelType());
        String templateId = notification.getTemplateId();
        String template = templateService.getTemplate(templateId);
        String content = String.format(template, notification.getCustomerName(), notification.getChannelType());
        messageDO.setContent(content);
        messageDO.setMessageAddress(notification.getReceiverPhoneNum());
        return messageDO;
    }

    @Override
    public void sendMessage(MessageDO message) {
        System.out.println("SMS RPC SERVICE call notification service WITH message: " + JSON.toJSONString(message));
    }


}
