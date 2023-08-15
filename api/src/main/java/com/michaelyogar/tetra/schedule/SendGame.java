package com.michaelyogar.tetra.schedule;

import com.michaelyogar.tetra.choice.ChoiceRepository;
import com.michaelyogar.tetra.choice.model.MultipleChoice;
import com.michaelyogar.tetra.email.AwsSesEmailService;
import com.michaelyogar.tetra.game.GameRepository;
import com.michaelyogar.tetra.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SendGame {
    private final AwsSesEmailService service;
    private final GameRepository gameRepository;
    private final ChoiceRepository choiceRepository;

    @Autowired
    public SendGame(AwsSesEmailService awsSesEmailService, GameService gameService, GameRepository gameRepository, ChoiceRepository choiceRepository) {
        this.gameRepository = gameRepository;
        this.choiceRepository = choiceRepository;
        this.service = awsSesEmailService;
    }

    @Scheduled(fixedRate = 5000)
    public void sendGame() throws Exception {
        long gameId = gameRepository.findBySmallestId().getGameId();
        List<MultipleChoice> multipleChoices = choiceRepository.findMultipleChoiceByGameId(gameId);
        for (MultipleChoice multipleChoice : multipleChoices) {
            System.out.println("- " + multipleChoice.getTitle() + " " + multipleChoice.getChoice_text());
        }

        // TODO: send email with Apache FreeMarker
    }
}
