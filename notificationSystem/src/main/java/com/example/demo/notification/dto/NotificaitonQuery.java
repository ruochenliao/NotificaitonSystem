package com.example.demo.notification.dto;

import lombok.Data;

@Data
public class NotificaitonQuery {
    private String notificaitonId;
    private String customerId;
    private Integer curPage;
    private Integer pageSize;
}
