package com.michaelyogar.tetra.choice;

import jakarta.persistence.*;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long choice_id;

    private String choiceText;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean correct;

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public long getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(long choice_id) {
        this.choice_id = choice_id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
