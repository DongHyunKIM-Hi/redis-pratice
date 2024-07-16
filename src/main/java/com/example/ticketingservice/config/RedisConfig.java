package com.example.ticketingservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class RedisConfig {

    @Bean
    public JedisPool createJedisPool() {
        return new JedisPool("localhost", 6379);
    }
}