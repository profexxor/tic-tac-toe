package com.profexxor.tictactoe.model.dto;

import com.profexxor.tictactoe.model.CellValue;
import com.profexxor.tictactoe.model.Coordinates;
import lombok.Data;

@Data
public class Action {
    private Long id;
    private Coordinates coordinates;
    private CellValue cellValue;
}
