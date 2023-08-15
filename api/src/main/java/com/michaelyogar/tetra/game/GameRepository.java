package com.michaelyogar.tetra.game;

import com.michaelyogar.tetra.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository extends BaseRepository<Game> {

    private final EntityManager em;

    public GameRepository(EntityManager em) {
        super(em);
        this.em = em;
    }

    public int updateNameById(long id, String name) {
        getClassName();
        String q = "UPDATE Game g SET g.name = :name WHERE id = :id";
        return em.createQuery(q).setParameter("id", id).setParameter("name", name).executeUpdate();
    }
}
