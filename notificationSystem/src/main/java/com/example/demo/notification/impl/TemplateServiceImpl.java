package com.example.demo.notification.impl;

import com.example.demo.notification.TemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Map<String, String> templateMaps = new HashMap<>(5);

    /**
     * TODO MOCK HTML webpage config notification template
     */
    @PostConstruct
    public void init(){
        templateMaps.put("pay", "%s send %s message with orderId %s");
        templateMaps.put("order", "%s send %s message");
    }

    @Override
    public String getTemplate(String id) {
        return templateMaps.get(id);
    }
}
