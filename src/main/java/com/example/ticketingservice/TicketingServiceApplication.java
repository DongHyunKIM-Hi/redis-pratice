package com.example.ticketingservice;

import com.example.ticketingservice.entity.User;
import com.example.ticketingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@RequiredArgsConstructor
public class TicketingServiceApplication implements ApplicationRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(TicketingServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(User.builder().email("email@email.com").name("name").build());
        userRepository.save(User.builder().email("email2@email.com").name("name2").build());
        userRepository.save(User.builder().email("email3@email.com").name("name3").build());
        userRepository.save(User.builder().email("email4@email.com").name("name4").build());
    }
}
