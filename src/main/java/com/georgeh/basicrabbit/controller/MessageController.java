package com.georgeh.basicrabbit.controller;

import com.georgeh.basicrabbit.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create the REST endpoints for direct and fan routing.
 */
@RestController
public class MessageController {
    // producer class needs to be Autowired in.
    @Autowired
    RabbitMQProducer producer;

    @GetMapping("/direct")
    public ResponseEntity<String> response(@RequestParam("message") String message, @RequestParam("key") String key) {
        producer.sendMessage(message, key);
        return ResponseEntity.ok(String.format("Message sent using key:  %s: -> %s", key, message));
    }

    @GetMapping("/fan")
    public ResponseEntity<String> response(@RequestParam("message") String message) {
        producer.fanMessage(message);
        return ResponseEntity.ok(String.format("Message fanned: -> %s", message));
    }
}
