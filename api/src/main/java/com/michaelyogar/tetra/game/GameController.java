package com.michaelyogar.tetra.game;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
@RequestMapping("game")
public class GameController {

    private final GameService service;

    @Autowired
    public GameController(GameService gameService) {
        this.service = gameService;
    }

    @GetMapping("{id}")
    public Game get(@PathVariable("id") long id) {
        return service.getGameById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody GameDto gameDto) {
        Game game = GameMapper.MAPPER.gameDtoToGame(gameDto);
        service.createGame(game);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public int updateNameById(@PathVariable("id") long id, @RequestParam("name") String name) {
        return service.updateNameById(id, name);
    }
}
