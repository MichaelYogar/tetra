package com.michaelyogar.tetra.schedule;

import com.michaelyogar.tetra.app.choice.ChoiceService;
import com.michaelyogar.tetra.app.game.Game;
import com.michaelyogar.tetra.app.game.GameService;
import com.michaelyogar.tetra.app.user.User;
import com.michaelyogar.tetra.app.user.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Component
public class MailGame {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    private final GameService gameService;
    private final ChoiceService choiceService;
    private final UserService userService;

    @Autowired
    public MailGame(JavaMailSender mailSender, TemplateEngine templateEngine, GameService gameService, ChoiceService choiceService, UserService userService) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.gameService = gameService;
        this.choiceService = choiceService;
        this.userService = userService;
    }

    @Scheduled(initialDelay = 5000, fixedRate = 5000000)
    public void sendGame() throws Exception {

        Game game = gameService.findOldestUnsentGame();

        // TODO: Needs better error handling before going to production
        if (game == null) {
            LOGGER.error("Game not found");
            return;
        }

        long gameId = game.getGameId();
        String gameName = game.getName();

        Map<String, List<String>> multipleChoices = choiceService.findMultipleChoiceByGameId(gameId);
        String content = generateEmail(gameName, multipleChoices);

        List<User> users = this.userService.findAllUsers();

        for (User user : users)
            sendEmail(user.getEmailAddress(), "test", content);


        gameService.updateSentById(gameId, true);
    }

    private String generateEmail(String gameName, Map<String, List<String>> multipleChoices) {
        Context context = new Context();
        context.setVariable("gameName", gameName);
        context.setVariable("multipleChoices", multipleChoices);
        return templateEngine.process("welcome", context);
    }

    private void sendEmail(String recipient, String subject, String content) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED, StandardCharsets.UTF_8.name());
        helper.setFrom("michaelyogar878@gmail.com", "My Email Address");
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);
    }
}
