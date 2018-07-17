package com.epam.edp.foo.service.impl;

import com.epam.edp.foo.service.FooService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class FooServiceImpl implements FooService {

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void postMessage(String body) {
        rabbitTemplate.convertAndSend(routingkey, body);
    }
}
