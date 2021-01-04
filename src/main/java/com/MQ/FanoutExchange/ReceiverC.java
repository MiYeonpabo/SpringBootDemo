package com.MQ.FanoutExchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class ReceiverC {

    @RabbitHandler
    public void process(String message) {
        System.out.println("ReceiverC: " + message);
    }

}