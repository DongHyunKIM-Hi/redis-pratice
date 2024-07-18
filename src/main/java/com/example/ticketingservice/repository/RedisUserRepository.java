package com.example.ticketingservice.repository;

import com.example.ticketingservice.entity.RedisUser;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<RedisUser, Long> {

}
