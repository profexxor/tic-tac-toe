package com.profexxor.tictactoe.service;

import com.profexxor.tictactoe.model.Coordinates;
import com.profexxor.tictactoe.model.Game;
import com.profexxor.tictactoe.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class GameService {
//    private static final String boardTemplate = "Game ''{0}'':\n\n   A   B   C\n1  {1} | {2} | {3} \n  ---|---|---\n2  {4} | {5} | {6} \n  ---|---|---\n3  {7} | {8} | {9} ";
    private static final String boardTemplate = """
            Game ''{0}'':

                A   B   C
             1  {1} | {2} | {3}
               ---|---|---
             2  {4} | {5} | {6}
               ---|---|---
             3  {7} | {8} | {9}
            """;

    private final GameRepository repository;

    public GameService(GameRepository repository) {
        this.repository = repository;
    }

    public String getGameById(Long id) {
        Optional<Game> optionalGame = repository.findById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return formatGameState(game);
        } else {
            return "The game doesn't exist.";
        }
    }

    private String formatGameState(Game game) {
        return MessageFormat.format(
                boardTemplate,
                game.getId(),
                game.getCellR1C1(),
                game.getCellR1C2(),
                game.getCellR1C3(),
                game.getCellR2C1(),
                game.getCellR2C2(),
                game.getCellR2C3(),
                game.getCellR3C1(),
                game.getCellR3C2(),
                game.getCellR3C3());
    }

    public Long createNewGame() {
        return repository.save(new Game()).getId();
    }
}
