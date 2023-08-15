package com.michaelyogar.tetra.choice.model;

public class MultipleChoice {
    private String title;
    private String choice_text;

    public MultipleChoice(String title, String choice_text) {
        this.title = title;
        this.choice_text = choice_text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoice_text() {
        return choice_text;
    }

    public void setChoice_text(String choice_text) {
        this.choice_text = choice_text;
    }
}
