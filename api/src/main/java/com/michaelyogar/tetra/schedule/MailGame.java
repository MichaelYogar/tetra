package com.michaelyogar.tetra.schedule;

import com.michaelyogar.tetra.choice.ChoiceService;
import com.michaelyogar.tetra.email.AwsSesEmailService;
import com.michaelyogar.tetra.game.Game;
import com.michaelyogar.tetra.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Map;

@Component
public class MailGame {
    private final AwsSesEmailService awsSesEmailService;
    private final GameService gameService;
    private final ChoiceService choiceService;

    private final TemplateEngine templateEngine;


    @Autowired
    public MailGame(AwsSesEmailService awsSesEmailService, GameService gameService, ChoiceService choiceService, TemplateEngine templateEngine) {
        this.gameService = gameService;
        this.choiceService = choiceService;
        this.awsSesEmailService = awsSesEmailService;
        this.templateEngine = templateEngine;
    }

    @Scheduled(fixedRate = 5000)
    public void sendGame() throws Exception {

        Game game = gameService.findOldestUnsentGame();

        if (game == null) {
            System.out.println("Game not found, cant send email");
            return;
        }

        long gameId = game.getGameId();
        String gameName = game.getName();

        Map<String, List<String>> multipleChoices = choiceService.findMultipleChoiceByGameId(gameId);
        String content = generateEmail(gameName, multipleChoices);
        System.out.println(content);

        awsSesEmailService.sendEmail("tentenmichael@gmail.com", "test", content);

        gameService.updateSentById(gameId, true);
    }

    private String generateEmail(String gameName, Map<String, List<String>> multipleChoices) {
        Context context = new Context();
        context.setVariable("gameName", gameName);
        context.setVariable("multipleChoices", multipleChoices);
        return templateEngine.process("welcome", context);
    }
}
