package com.michaelyogar.tetra.app.choice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChoiceService {
    private final ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public void save(Choice entity) {
        choiceRepository.save(entity);
    }

    public Map<String, List<String>> findMultipleChoiceByGameId(long gameId) {
        return choiceRepository.findMultipleChoiceByGameId(gameId);
    }
}
