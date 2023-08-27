package com.georgeh.basicrabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //Get all static names
    @Value("${rabbit.exchange.exchange1.name}")
    private String exchange;

    @Value("${rabbit.exchange.fanout.name}")
    private  String fanoutex;

    public void sendMessage(String message, String routingKey) {
        System.out.println(String.format("Message sent on Routing Key:  %s -> %s", routingKey, message));
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

    public void fanMessage(String message) {
        System.out.println(String.format("Fanning the message -> %s", message));
        rabbitTemplate.convertAndSend(fanoutex, "", message);
    }
}
