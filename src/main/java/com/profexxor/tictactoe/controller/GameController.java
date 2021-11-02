package com.profexxor.tictactoe.controller;

import com.profexxor.tictactoe.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameController>> getGames() {
        try {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = "text/plain")
    public ResponseEntity<String> getGameById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Long> newGame() {
        try {
            return new ResponseEntity<>(gameService.createNewGame(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
