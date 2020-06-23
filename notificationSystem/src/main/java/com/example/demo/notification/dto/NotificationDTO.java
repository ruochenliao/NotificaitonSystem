package com.example.demo.notification.dto;

import lombok.Data;

import java.util.Map;

/**
 * @author JOHN
 */
@Data
public class NotificationDTO {
    String customerId;
    String templateId;
    String customerName;
    String channelType;
    String lang;
    String receiverEmail;
    String receiverPhoneNum;
    Map<String, String> payload;
}
