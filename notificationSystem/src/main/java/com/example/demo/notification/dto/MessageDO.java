package com.example.demo.notification.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class MessageDO {
    private String channelType;
    private String content;
    private String messageAddress;
    private Instant gmtCreate;
    private Instant gmtModified;
}
