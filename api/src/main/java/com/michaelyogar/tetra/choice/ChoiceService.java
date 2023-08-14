package com.michaelyogar.tetra.choice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {
    private final ChoiceRepository<Choice> choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository<Choice> choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public void save(Choice entity) {
        choiceRepository.save(entity);
    }
}
