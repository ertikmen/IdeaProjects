package com.ertikmen.config.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${rabbitmq.mail-queue}")
    private String mailQueueName;

    @Bean
    public Queue mailQueue(){
        return new Queue(mailQueueName);
    }

}