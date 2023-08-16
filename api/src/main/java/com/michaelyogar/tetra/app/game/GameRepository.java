package com.michaelyogar.tetra.app.game;

import com.michaelyogar.tetra.app.base.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository extends BaseRepository<Game> {

    private final EntityManager em;

    public GameRepository(EntityManager em) {
        super(em);
        this.em = em;
    }

    public Game findOldestUnsentGame() {
        String q = "Select g from Game g WHERE g.sent = false order by g.created_date limit 1";
        Query query = em.createQuery(q);
        return (Game) query.getSingleResult();
    }

    public int updateNameById(long id, String name) {
        String q = "UPDATE Game g SET g.name = :name WHERE id = :id";
        return em.createQuery(q).setParameter("id", id).setParameter("name", name).executeUpdate();
    }

    public int updateSentById(long id, boolean sent) {
        String q = "UPDATE Game g SET g.sent = :sent WHERE id = :id";
        return em.createQuery(q).setParameter("id", id).setParameter("sent", sent).executeUpdate();
    }
}
