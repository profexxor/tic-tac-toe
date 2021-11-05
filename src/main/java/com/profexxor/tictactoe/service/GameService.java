package com.profexxor.tictactoe.service;

import com.profexxor.tictactoe.model.CellValue;
import com.profexxor.tictactoe.model.Game;
import com.profexxor.tictactoe.model.dto.Action;
import com.profexxor.tictactoe.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

@Service
public class GameService {
    private static final String GRID_TMPL = """
            Game ''{0}'':

                  A   B   C
                ┌───┬───┬───┐
              1 │ {1} │ {2} │ {3} │
                ├───┼───┼───┤
              2 │ {4} │ {5} │ {6} │
                ├───┼───┼───┤
              3 │ {7} │ {8} │ {9} │
                └───┴───┴───┘
            """;
    private static final String WINNER_TMPL = """

            ''{0}'' is the WINNER!
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
                GRID_TMPL,
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

    public String action(Action action) {
        Game game = getGame(action.getId());
        CellValue cellValue = action.getCellValue();

        switch (action.getCoordinates()) {
            case R1C1:
                if (game.getCellR1C1() == CellValue.EMPTY) {
                    game.setCellR1C1(cellValue);
                }
                break;
            case R1C2:
                if (game.getCellR1C2() == CellValue.EMPTY) {
                    game.setCellR1C2(cellValue);
                }
                break;
            case R1C3:
                if (game.getCellR1C3() == CellValue.EMPTY) {
                    game.setCellR1C3(cellValue);
                }
                break;
            case R2C1:
                if (game.getCellR2C1() == CellValue.EMPTY) {
                    game.setCellR2C1(cellValue);
                }
                break;
            case R2C2:
                if (game.getCellR2C2() == CellValue.EMPTY) {
                    game.setCellR2C2(cellValue);
                }
                break;
            case R2C3:
                if (game.getCellR2C3() == CellValue.EMPTY) {
                    game.setCellR2C3(cellValue);
                }
                break;
            case R3C1:
                if (game.getCellR3C1() == CellValue.EMPTY) {
                    game.setCellR3C1(cellValue);
                }
                break;
            case R3C2:
                if (game.getCellR3C2() == CellValue.EMPTY) {
                    game.setCellR3C2(cellValue);
                }
                break;
            case R3C3:
                if (game.getCellR3C3() == CellValue.EMPTY) {
                    game.setCellR3C3(cellValue);
                }
                break;
        }
        repository.save(game);

        String result = formatGameState(game);
        if (checkWinner(game, cellValue) != CellValue.EMPTY) {
            result += MessageFormat.format(WINNER_TMPL, cellValue);
        }
        return result;
    }

    private Game getGame(Long id) {
        boolean gameExists = repository.existsById(id);
        if (gameExists) {
            return repository.getById(id);
        } else {
            return repository.save(new Game());
        }
    }

    private CellValue checkWinner(Game game, CellValue cellValue) {
        if (cellValue == game.getCellR1C1() && cellValue == game.getCellR1C2() && cellValue == game.getCellR1C3()) {
            return cellValue;
        } else if (cellValue == game.getCellR2C1() && cellValue == game.getCellR2C2() && cellValue == game.getCellR2C3()) {
            return cellValue;
        } else if (cellValue == game.getCellR3C1() && cellValue == game.getCellR3C2() && cellValue == game.getCellR3C3()) {
            return cellValue;
        } else if (cellValue == game.getCellR1C1() && cellValue == game.getCellR2C1() && cellValue == game.getCellR3C1()) {
            return cellValue;
        } else if (cellValue == game.getCellR1C2() && cellValue == game.getCellR2C2() && cellValue == game.getCellR3C2()) {
            return cellValue;
        } else if (cellValue == game.getCellR1C3() && cellValue == game.getCellR2C3() && cellValue == game.getCellR3C3()) {
            return cellValue;
        } else if (cellValue == game.getCellR1C1() && cellValue == game.getCellR2C2() && cellValue == game.getCellR3C3()) {
            return cellValue;
        } else if (cellValue == game.getCellR1C3() && cellValue == game.getCellR2C2() && cellValue == game.getCellR3C1()) {
            return cellValue;
        }
        return CellValue.EMPTY;
    }
}
