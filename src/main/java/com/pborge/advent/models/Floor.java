package com.pborge.advent.models;

import java.util.Arrays;

public class Floor {
    private final Cell[][] cells;

    public Floor(int width, int height) {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++)
            Arrays.fill(cells[i], new Cell("L"));
    }

    public void add(Cell cell, int i, int j) {
        cells[i][j] = cell;
    }

    public Cell get(int i, int j) {
        return cells[i][j];
    }

    public int getWidth() {
        if (cells == null)
            return 0;
        return cells.length;
    }

    public int getHeight() {
        if (cells == null)
            return 0;
        return cells[0].length;
    }

    public int countOccupiedNeighbors(int i, int j, boolean skipEmptySeats) {
        if (skipEmptySeats)
            return countOccupiedNeighborsSkipEmptySeats(i, j);
        return countOccupiedNeighborsCountEmptySeats(i, j);
    }

    public Integer getOccupiedSeats() {
        int occupiedSeats = 0;
        for (Cell[] row : cells) {
            for (Cell cell : row)
                occupiedSeats += cell.isOccupied() ? 1 : 0;
        }
        return occupiedSeats;
    }

    public void print() {
        String line = "\n";
        for (int i = 0; i < cells.length; i++) {
            line += i + (i > 9 ? "" : " ") + ": |";
            for (int j = 0; j < cells[i].length; j++) {
                line += cells[i][j].isSeat() ? cells[i][j].isOccupied() ? " #" : " L" : " ." ;
            }
            line += " |\n";
        }
        line += "\n";
        System.out.println(line);
    }

    private int countOccupiedNeighborsCountEmptySeats(int row, int column) {
        int occupiedNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i == row && j == column)
                    continue;
                try {
                    if (get(i, j).isOccupied())
                        occupiedNeighbors++;
                } catch (IndexOutOfBoundsException e) {}
            }
        }

        return occupiedNeighbors;
    }

    private int countOccupiedNeighborsSkipEmptySeats(int row, int column) {
        int occupiedNeighbors = 0;
        if (!get(row, column).isSeat())
            return 0;
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                if (i == row && j == column)    // Don't test the current seat
                    continue;
                if (!get(i, j).isSeat())        // Don't test non seats
                    continue;
                if (!isVisible(row, column, i, j))    // Don't test the seats you can't see
                    continue;
                try {
                    if (get(i, j).isOccupied()) {
                        occupiedNeighbors++;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return occupiedNeighbors;
    }

    private boolean isVisible(int row, int column, int i, int j) {
        try {
            if (i == row) {
                for (int currentColumn = Math.min(column, j) + 1; currentColumn <= Math.max(column, j); currentColumn++) {
                    if (get(i, currentColumn).isSeat())
                        return currentColumn == column || currentColumn == j;
                }
            }
            if (j == column) {
                for (int currentRow = Math.min(row, i) + 1; currentRow <= Math.max(row, i); currentRow++) {
                    if (get(currentRow, j).isSeat())
                        return currentRow == row || currentRow == i;
                }
            }
            if ((i - j) == (row - column)) {
                for (int index = 1; index <= Math.abs(i - row); index++) {
                    if (get(Math.min(i, row) + index, Math.min(j, column) + index).isSeat())
                        return (Math.min(i, row) + index) == Math.max(i, row) && (Math.min(j, column) + index) == Math.max(j, column);
                }
            }
            if ((i + j) == (row + column)) {
                for (int index = 1; index <= Math.abs(i - row); index++) {
                    if (get(Math.min(i, row) + index, Math.max(j, column) - index).isSeat())
                        return (Math.min(i, row) + index) == Math.max(i, row) && (Math.max(j, column) - index) == Math.min(j, column);
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        return false;
    }
}
