package com.michaelyogar.tetra.app.question;

import com.michaelyogar.tetra.app.base.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepository extends BaseRepository<Question> {

    private final EntityManager em;

    @Autowired
    public QuestionRepository(EntityManager em) {
        super(em);
        this.em = em;
    }

//    public List<String> findQuestionsByGame(long gameId) {
//        String q = "select game_id, question_id from game as t1 inner join question as t2 where t1.game_id = t2.fk_game_id";
//        em.createNativeQuery()
//    }
}
