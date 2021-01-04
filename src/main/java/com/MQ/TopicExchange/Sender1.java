package com.MQ.TopicExchange;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, i am message 1" + new Date();
        System.out.println("Sender1:" + context);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }
}
