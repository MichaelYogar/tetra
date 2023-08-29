package com.michaelyogar.tetra.seed;

import com.michaelyogar.tetra.app.answer.Answer;
import com.michaelyogar.tetra.app.answer.AnswerRepository;
import com.michaelyogar.tetra.app.choice.Choice;
import com.michaelyogar.tetra.app.choice.ChoiceRepository;
import com.michaelyogar.tetra.app.game.Game;
import com.michaelyogar.tetra.app.game.GameRepository;
import com.michaelyogar.tetra.app.question.Question;
import com.michaelyogar.tetra.app.question.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Profile("dev")
public class CreateGame implements CommandLineRunner {
    private final GameRepository gameRepository;
    private final QuestionRepository questionRepository;
    private final ChoiceRepository choiceRepository;
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
        for (int i = 0; i < 1; i++) {
            createGame(i);
        }
    }

    private void createGame(int index) {
        Game game = new Game();

        for (int i = 0; i < 2; i++) {
            Question question = new Question();
            question.setTitle("Question " + i);
            game.getQuestions().add(question);

            int numOfChoices = 3;
            int randomNumber = getRandomNumber(numOfChoices);

            Choice answerChoice = null;

            for (int j = 0; j < numOfChoices; j++) {
                Choice choice = new Choice();
                choice.setChoiceText(getRandomString(j));
                choice.setCorrect(false);

                if (j == randomNumber) {
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
        }

        game.setName("New game" + index);
        gameRepository.save(game);
    }

    private String getRandomString(int index) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return "Choice: " + index + ": " + generatedString;
    }

    private int getRandomNumber(int upperBound) {
        Random rand = new Random();
        return rand.nextInt(upperBound);
    }
}
