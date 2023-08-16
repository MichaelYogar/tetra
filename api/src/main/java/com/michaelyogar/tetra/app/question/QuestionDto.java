package com.michaelyogar.tetra.app.question;

import com.michaelyogar.tetra.app.choice.ChoiceDto;

import java.util.List;

public class QuestionDto {
    private String title;

    List<ChoiceDto> choices;

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public List<ChoiceDto> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceDto> choices) {
        this.choices = choices;
    }
}
