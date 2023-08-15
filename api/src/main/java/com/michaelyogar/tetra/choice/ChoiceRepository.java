package com.michaelyogar.tetra.choice;

import com.michaelyogar.tetra.choice.model.MultipleChoice;
import com.michaelyogar.tetra.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChoiceRepository extends BaseRepository<Choice> {
    private final EntityManager em;

    @Autowired
    public ChoiceRepository(EntityManager em) {
        super(em);
        this.em = em;
    }

    public List<MultipleChoice> findMultipleChoiceByGameId(long gameId) {
        String q = "select title, choice_text from choice as t1 left join question as t2 on t1.fk_question_id = t2.question_id WHERE fk_game_id = " + gameId;

        List<Object[]> results = em.createNativeQuery(q).getResultList();

        List<MultipleChoice> multipleChoices = new ArrayList<>();

        for (Object[] result : results) {
            MultipleChoice multipleChoice = new MultipleChoice((String) result[0], (String) result[1]);
            multipleChoices.add(multipleChoice);
        }

        return multipleChoices;
    }
}
