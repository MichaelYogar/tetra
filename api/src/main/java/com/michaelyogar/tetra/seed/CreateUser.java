package com.michaelyogar.tetra.seed;

import com.michaelyogar.tetra.app.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
public class CreateUser implements CommandLineRunner {
    private final UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser("tentenmichael@gmail.com");
    }
}
