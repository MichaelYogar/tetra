package com.michaelyogar.tetra.app.game;

import com.michaelyogar.tetra.app.choice.Choice;
import com.michaelyogar.tetra.app.choice.ChoiceService;
import com.michaelyogar.tetra.app.question.Question;
import com.michaelyogar.tetra.app.question.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final QuestionService questionService;
    private final ChoiceService choiceService;

    @Autowired
    public GameService(GameRepository repository, QuestionService questionService, ChoiceService choiceService) {
        this.gameRepository = repository;
        this.questionService = questionService;
        this.choiceService = choiceService;
    }

    public Game findGameById(long id) {
        Game game = gameRepository.findById(id);
        if (game == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Game with id %d not found", id));
        return game;
    }

    public Game findOldestUnsentGame() {
        try {
            return gameRepository.findOldestUnsentGame();
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional()
    public void createGame(Game game) throws Exception {
        for (Question question : game.getQuestions()) {

            for (Choice choice : question.getChoices())
                this.choiceService.save(choice);

            this.questionService.save(question);
        }

        game.setSent(false);
        gameRepository.save(game);
    }


    @Transactional
    public int updateSentById(long id, boolean sent) {
        return gameRepository.updateSentById(id, sent);
    }

    @Transactional
    public int updateNameById(long id, String name) {
        return gameRepository.updateNameById(id, name);
    }
}
