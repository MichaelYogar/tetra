package com.michaelyogar.tetra.game;

import com.michaelyogar.tetra.question.Question;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long game_id;

    private String name;

    @CreatedDate
    private Instant created_date;

    @OneToMany(cascade = CascadeType.MERGE) // unidirectional
    @JoinColumn(name = "fk_game_id")
    private List<Question> questions = new ArrayList<>();

    public Long getGameId() {
        return game_id;
    }

    public Instant getCreatedDate() {
        return created_date;
    }

    public void setCreatedDate(Instant created_date) {
        this.created_date = created_date;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
