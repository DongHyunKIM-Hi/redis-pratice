package com.example.ticketingservice.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

@Slf4j
public class MassageListenerService implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Message received: {} chanel: {}", new String(message.getBody()), message.getChannel());
    }
}
