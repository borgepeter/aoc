package com.pborge.advent.models;

public class Seat {
    private int row;
    private int column;
    private int id;

    public Seat(int row, int column, int id) {
        this.row = row;
        this.column = column;
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getId() {
        return id;
    }
}
