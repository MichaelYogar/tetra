package com.michaelyogar.tetra.question;

import com.michaelyogar.tetra.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository<T> extends BaseRepository<T> {

    private final EntityManager em;

    @Autowired
    public QuestionRepository(EntityManager em) {
        super(em);
        this.em = em;
    }
}
