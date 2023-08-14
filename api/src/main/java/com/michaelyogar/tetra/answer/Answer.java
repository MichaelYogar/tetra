package com.michaelyogar.tetra.answer;

import com.michaelyogar.tetra.choice.Choice;
import com.michaelyogar.tetra.question.Question;
import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    @OneToOne(optional = false)
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(optional = false)
    @JoinColumn(name = "choice_id")
    private Choice choice;

    public Long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Long answer_id) {
        this.answer_id = answer_id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
