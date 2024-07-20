package com.example.ticketingservice.controller;

import com.example.ticketingservice.entity.RedisUser;
import com.example.ticketingservice.entity.User;
import com.example.ticketingservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}/email")
    public User getUserEmail(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/user/{id}/email/v1")
    public User getUserEmailV1(@PathVariable Long id) {
        return userService.getUserV1(id);
    }


    @GetMapping("/user/{id}/email/v2")
    public RedisUser getUserEmailV2(@PathVariable Long id) {
        return userService.getUserV2(id);
    }

    @GetMapping("/user/{id}/email/v3")
    public User getUserEmailV3(@PathVariable Long id) {
        return userService.getUserV3(id);
    }
}
