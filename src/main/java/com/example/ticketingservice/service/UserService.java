package com.example.ticketingservice.service;

import com.example.ticketingservice.entity.RedisUser;
import com.example.ticketingservice.entity.User;
import com.example.ticketingservice.repository.RedisUserRepository;
import com.example.ticketingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RedisTemplate<String, User> redisTemplate;
    private final RedisUserRepository redisUserRepository;
    ;


    public User getUser(Long id) {
        var key = "user:%d".formatted(id);
        var user = redisTemplate.opsForValue().get(key);

        if (user != null) {
            return user;
        }

        user = userRepository.findById(id).orElseThrow();
        redisTemplate.opsForValue().set(key, user);
        return user;
    }

    public RedisUser getUserV2(Long id) {
        var key = "user:%d".formatted(id);
        return redisUserRepository.findById(id).orElseGet(() -> {
            User user = userRepository.findById(id).orElseThrow();
            return redisUserRepository.save(RedisUser.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build());
        });
    }

}
