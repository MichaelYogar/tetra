package com.michaelyogar.tetra.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository<Question> questionRepository;

    @Autowired
    public QuestionService(QuestionRepository<Question> questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void save(Question entity) {
        this.questionRepository.save(entity);
    }
}
