package com.example.user_service2.controller;

import com.example.user_service2.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/1")
    public User getUser() {
        return new User(1L, "Alice", "alice@example.com");
    }
}
