package com.example.user.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public void processUser(String userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            handleMissingUser(userId);
            throw new UserNotFoundException("User not found: " + userId);
        }
        Email email = new Email(user.getId(), "Welcome", "Hello " + user.getName());
        emailSender.send(email);
    }

    public void handleMissingUser(String userId) {
        // For test verification
    }
}
