package com.michaelyogar.tetra.seed;

import com.michaelyogar.tetra.app.user.User;
import com.michaelyogar.tetra.app.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Profile("dev")
@Component
public class CreateUser implements CommandLineRunner, Seed {
    private final UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (seeded())
            return;

        User user = new User();
        user.setEmailAddress("tentenmichael@gmail.com");
        userService.createUser(user);
    }

    public boolean seeded() {
        return userService.isEmpty();
    }
}