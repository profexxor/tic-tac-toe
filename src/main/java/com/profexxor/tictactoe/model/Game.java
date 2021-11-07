package com.profexxor.tictactoe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private CellValue cellR1C1 = CellValue.EMPTY;
    private CellValue cellR1C2 = CellValue.EMPTY;
    private CellValue cellR1C3 = CellValue.EMPTY;
    private CellValue cellR2C1 = CellValue.EMPTY;
    private CellValue cellR2C2 = CellValue.EMPTY;
    private CellValue cellR2C3 = CellValue.EMPTY;
    private CellValue cellR3C1 = CellValue.EMPTY;
    private CellValue cellR3C2 = CellValue.EMPTY;
    private CellValue cellR3C3 = CellValue.EMPTY;
}
