package com.example.ticketingservice.controller;

import com.example.ticketingservice.entity.User;
import com.example.ticketingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final JedisPool jedisPool;

    @GetMapping("/user/{id}/email")
    public String getUserEmail(@PathVariable Long id) {

        var jedisEmailKey = "users:%d:email".formatted(id);

        try (Jedis jedis = jedisPool.getResource()) {
            String email = jedis.get(jedisEmailKey);
            if (email != null) {
                return email;
            }
            email = userRepository.findById(id).orElse(User.builder().build()).getEmail();
            jedis.set(jedisEmailKey, email);
            jedis.setex(jedisEmailKey, 30, email);
            return email;

        }
    }
}
