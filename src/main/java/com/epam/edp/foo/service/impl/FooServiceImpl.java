package com.epam.edp.foo.service.impl;

import com.epam.edp.foo.service.FooService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Pavlo_Yemelianov
 */
@Service
public class FooServiceImpl implements FooService {

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RestTemplate restTemplate;

    public void postMessage(String body) {
        rabbitTemplate.convertAndSend(routingkey, body);
    }

    @Retryable(
            value = {Exception.class},
            maxAttempts = 4,
            backoff = @Backoff(delay = 1000)
    )
    public String getDumbClientResponse() {
        return restTemplate.getForEntity("http://bar-service:8080/dumb/client", String.class).getBody();
    }
}
