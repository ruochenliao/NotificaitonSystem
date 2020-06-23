package com.example.demo.notification.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.notification.dto.MessageDO;
import com.example.demo.notification.dto.NotificationDTO;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificaitonServiceImpl extends AbstractNotificationService {

    @Override
    public boolean validate(NotificationDTO notification) {
        System.out.println("validate email");
        return "EMAIL".equalsIgnoreCase(notification.getChannelType());
    }

    @Override
    public MessageDO buildMessage(NotificationDTO notification) {
        //build email message
        MessageDO messageDO = new MessageDO();
        messageDO.setChannelType(notification.getChannelType());
        String templateId = notification.getTemplateId();
        String template = templateService.getTemplate(templateId);

        //TODO MOCK convert map to HTML model's key and value
        String content = String.format(template, notification.getCustomerName(), notification.getChannelType(), notification.getPayload().get("orderId"));
        messageDO.setContent(content);
        messageDO.setMessageAddress(notification.getReceiverEmail());
        return messageDO;
    }

    @Override
    public void sendMessage(MessageDO message) {
        System.out.println("EMAIL RPC SERVICE call notification service WITH message: " + JSON.toJSONString(message));
    }
}
