package com.example.ticketingservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PubSubController {

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("/pub/message")
    public void publishMessage() {
        redisTemplate.convertAndSend("ticketing", "test");
    }
}
