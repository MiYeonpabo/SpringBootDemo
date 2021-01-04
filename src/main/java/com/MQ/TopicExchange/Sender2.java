package com.MQ.TopicExchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message 2" + new Date();
        System.out.println("Sender2:" + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }
}
