package com.michaelyogar.tetra.choice;

import com.michaelyogar.tetra.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChoiceRepository<T> extends BaseRepository<T> {
    private final EntityManager em;

    @Autowired
    public ChoiceRepository(EntityManager em) {
        super(em);
        this.em = em;
    }
}
