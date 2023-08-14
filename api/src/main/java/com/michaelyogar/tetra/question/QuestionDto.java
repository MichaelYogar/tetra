package com.michaelyogar.tetra.question;

import com.michaelyogar.tetra.choice.ChoiceDto;

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
