package com.michaelyogar.tetra.game;

import com.michaelyogar.tetra.choice.Choice;
import com.michaelyogar.tetra.choice.ChoiceService;
import com.michaelyogar.tetra.question.Question;
import com.michaelyogar.tetra.question.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {
    private final GameRepository<Game> repository;
    private final QuestionService questionService;
    private final ChoiceService choiceService;

    @Autowired
    public GameService(GameRepository<Game> repository, QuestionService questionService, ChoiceService choiceService) {
        this.repository = repository;
        this.questionService = questionService;
        this.choiceService = choiceService;
    }

    public Game getGameById(long id) {
        Game game = repository.findById(Game.class, id);
        if (game == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Game with id %d not found", id));
        return game;
    }

    public void createGame(Game game) {
        for (Question question : game.getQuestions()) {

            for (Choice choice : question.getChoices())
                this.choiceService.save(choice);

            this.questionService.save(question);
        }

        repository.save(game);
    }

    @Transactional()
    public int updateNameById(long id, String name) {
        return repository.updateNameById(id, name);
    }
}
