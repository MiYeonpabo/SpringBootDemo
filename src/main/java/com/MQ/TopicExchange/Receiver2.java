package com.MQ.TopicExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class Receiver2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver2: " + message);
    }

}