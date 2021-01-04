package com.MQ.DirectExchange;

import com.Model.UserInfo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1: " + hello);
    }


    @RabbitHandler
    public void process(UserInfo userInfo) {
        System.out.println("Receiver1: " + userInfo);
    }

}

