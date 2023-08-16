package com.michaelyogar.tetra.choice;

import com.michaelyogar.tetra.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChoiceRepository extends BaseRepository<Choice> {
    private final EntityManager em;

    @Autowired
    public ChoiceRepository(EntityManager em) {
        super(em);
        this.em = em;
    }

    public Map<String, List<String>> findMultipleChoiceByGameId(long gameId) {
        String q = "select title, choice_text from choice as t1 left join question as t2 on t1.fk_question_id = t2.question_id WHERE fk_game_id = " + gameId;
        List<Object[]> results = em.createNativeQuery(q).getResultList();

        Map<String, List<String>> map = new HashMap<>();

        for (Object[] result : results) {
            String title = (String) result[0];

            if (!map.containsKey(result[0])) map.put(title, new ArrayList<String>());

            map.get(title).add((String) result[1]);
        }

        return map;
    }
}
