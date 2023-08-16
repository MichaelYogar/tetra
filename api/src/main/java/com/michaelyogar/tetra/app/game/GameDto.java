package com.michaelyogar.tetra.app.game;

import com.michaelyogar.tetra.app.question.QuestionDto;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GameDto {

    @NotNull
    private String name;

    private List<QuestionDto> questions = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }
}
