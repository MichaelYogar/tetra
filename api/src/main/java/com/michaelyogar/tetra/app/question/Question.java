package com.michaelyogar.tetra.app.question;

import com.michaelyogar.tetra.app.choice.Choice;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

    @Column(nullable = false)
    private String title;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "fk_question_id")
    private List<Choice> choices = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String question_text) {
        this.title = question_text;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
