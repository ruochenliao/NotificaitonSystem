package com.example.demo.notification.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.notification.dto.MessageDO;
import com.example.demo.notification.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class InAppNotificationServiceImpl extends AbstractNotificationService {
    @Override
    public boolean validate(NotificationDTO notification) {
        System.out.println("validate in app message");
        return "IN_APP".equalsIgnoreCase(notification.getChannelType());
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
        messageDO.setMessageAddress(notification.getCustomerId());
        return messageDO;
    }

    @Override
    public void sendMessage(MessageDO message) {
        System.out.println("APP RPC SERVICE call notification service WITH message: " + JSON.toJSONString(message));
    }
}
