package com.michaelyogar.tetra.seed;

import com.michaelyogar.tetra.email.AwsSesEmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SendEmail implements CommandLineRunner {
    private final AwsSesEmailService service;

    public SendEmail(AwsSesEmailService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending email...");
        service.sendEmail("tentenmichael@gmail.com", "test", "test email from spring boot with aws");
    }
}
