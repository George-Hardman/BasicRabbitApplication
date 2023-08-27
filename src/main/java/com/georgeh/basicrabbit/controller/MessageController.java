package com.georgeh.basicrabbit.controller;

import com.georgeh.basicrabbit.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    RabbitMQProducer producer;

    @GetMapping("/api")
    public ResponseEntity<String> response(@RequestParam("send") String message, @RequestParam("key") String key) {
        producer.sendMessage(message, key);
        return ResponseEntity.ok(String.format("Message sent using key:  %s: -> %s", key, message));
    }

    @GetMapping("fan")
    public ResponseEntity<String> response(@RequestParam("message") String message) {
        producer.fanMessage(message);
        return ResponseEntity.ok(String.format("Message fanned: -> %s", message));
    }
}
