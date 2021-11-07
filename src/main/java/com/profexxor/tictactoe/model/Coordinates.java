package com.profexxor.tictactoe.model;

public enum Coordinates {
    R1C1("r1c1"), R1C2("r1c2"), R1C3("r1c3"),
    R2C1("r2c1"), R2C2("r2c2"), R2C3("r2c3"),
    R3C1("r3c1"), R3C2("r3c2"), R3C3("r3c3");

    String value;

    Coordinates(String s) {
        value = s;
    }

    @Override
    public String toString() {
        return value;
    }
}
