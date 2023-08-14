package com.michaelyogar.tetra.seed;

import com.michaelyogar.tetra.answer.Answer;
import com.michaelyogar.tetra.answer.AnswerRepository;
import com.michaelyogar.tetra.choice.Choice;
import com.michaelyogar.tetra.choice.ChoiceRepository;
import com.michaelyogar.tetra.game.Game;
import com.michaelyogar.tetra.game.GameRepository;
import com.michaelyogar.tetra.question.Question;
import com.michaelyogar.tetra.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CreateGame implements CommandLineRunner {
    private final GameRepository gameRepository;
    private final QuestionRepository<Question> questionRepository;
    private final ChoiceRepository<Choice> choiceRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public CreateGame(GameRepository gameRepository, QuestionRepository questionRepository, ChoiceRepository choiceRepository, AnswerRepository answerRepository) {
        this.gameRepository = gameRepository;
        this.questionRepository = questionRepository;
        this.choiceRepository = choiceRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Question question = new Question();
        question.setTitle("New Question 2");

        int numOfChoices = 4;
        int randomNumber = getRandomNumber(numOfChoices);

        Choice answerChoice = null;

        for (int i = 0; i < numOfChoices; i++) {
            Choice choice = new Choice();
            choice.setChoiceText("Choice: " + i);
            choice.setCorrect(false);

            if (i == randomNumber) {
                choice.setCorrect(true);
                answerChoice = choice;
            }

            choiceRepository.save(choice);
            question.getChoices().add(choice);
        }

        questionRepository.save(question);

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setChoice(answerChoice);
        answerRepository.save(answer);

        Game game = new Game();
        game.getQuestions().add(question);
        gameRepository.save(game);
    }

    private int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound);
    }
}
