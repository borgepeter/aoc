package com.pborge.advent.models;

public class Cell {
    private boolean isSeat = false;
    private boolean isOccupied = false;

    public Cell(String data) {
        if ("#".equalsIgnoreCase(data)) {
            this.isSeat = true;
            this.isOccupied = true;
        }
        if ("L".equalsIgnoreCase(data)) {
            this.isSeat = true;
        }
    }

    public Cell(Cell cell) {
        this.isSeat = cell.isSeat;
        this.isOccupied = cell.isOccupied;
    }

    public void toggleSeat() {
        if (isSeat) {
            this.isOccupied = !isOccupied;
        }
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isSeat() {
        return isSeat;
    }
}
