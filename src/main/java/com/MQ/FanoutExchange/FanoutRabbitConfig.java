package com.MQ.FanoutExchange;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FanoutRabbitConfig {

    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean(name = "fanoutExchange")
    public FanoutExchange exchange() {
        return new FanoutExchange("fanoutExchange");
    }

//    @Bean
//    public Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutEchange) {
//        return BindingBuilder.bind(AMessage).to(fanoutEchange);
//    }
//
//    @Bean
//    public Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutEchange) {
//        return BindingBuilder.bind(BMessage).to(fanoutEchange);
//    }
//
//    @Bean
//    public Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutEchange) {
//        return BindingBuilder.bind(CMessage).to(fanoutEchange);
//    }
}
