package com.michaelyogar.tetra.app.choice;

public class ChoiceDto {

    private String value;

    private boolean correct;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
