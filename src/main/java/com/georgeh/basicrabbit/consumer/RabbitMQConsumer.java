package com.georgeh.basicrabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Create listeners for each of the Queues.
 * When a message is received, print this to the console.
 */
@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "${rabbit.queue.queue1.name}")
    public void listen1(String message) {
        System.out.println(String.format("Received Message from Q1 -> %s", message));
    }
    @RabbitListener(queues = "${rabbit.queue.queue2.name}")
    public void listen2(String message) {
        System.out.println(String.format("Received Message from Q2 -> %s", message));
    }
    @RabbitListener(queues = "${rabbit.queue.queue3.name}")
    public void listen3(String message) {
        System.out.println(String.format("Received Message from Q3 -> %s", message));
    }
}
