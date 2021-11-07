package com.profexxor.tictactoe.model;

public enum CellValue {
    EMPTY(" "), X("X"), O("O");

    String value;

    CellValue(String s) {
        value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
