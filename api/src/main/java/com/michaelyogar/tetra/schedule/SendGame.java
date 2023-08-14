package com.michaelyogar.tetra.schedule;

import com.michaelyogar.tetra.email.AwsSesEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendGame {
    private final AwsSesEmailService service;

    @Autowired
    public SendGame(AwsSesEmailService awsSesEmailService) {
        this.service = awsSesEmailService;
    }


    @Scheduled(fixedRate = 10000)
    public void sendGame() throws Exception {
        service.sendEmail("tentenmichael@gmail.com", "test", "contents for trivia");
    }
}
