package com.epam.edp.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for rabbitmq
 **/
@Configuration
public class RabbitMqConfig {
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(exchange);
        return rabbitTemplate;
    }

    /**
     * Creates new header exchange on rabbitmq server with name from rabbitmq.properties, if it doesn't exist
     *
     * @return instance of HeadersExchange
     */
    @Bean
    public DirectExchange headersExchange() {
        return new DirectExchange(exchange);
    }
}
