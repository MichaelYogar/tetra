package com.michaelyogar.tetra.app.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String emailAddress) {
        User user = new User();
        user.setEmailAddress(emailAddress);
        this.userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return this.userRepository.findAllUsers();
    }
}
