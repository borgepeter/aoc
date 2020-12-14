package com.pborge.advent.models;

public class Cell {
    private final int row;
    private final int column;
    private boolean isSeat = false;
    private boolean isOccupied = false;

    public Cell(String data, int row, int column) {
        this.row = row;
        this.column = column;
        if ("#".equalsIgnoreCase(data)) {
            this.isSeat = true;
            this.isOccupied = true;
        }
        if ("L".equalsIgnoreCase(data)) {
            this.isSeat = true;
        }
    }

    public Cell(Cell cell) {
        this.row = cell.row;
        this.column = cell.column;
        this.isSeat = cell.isSeat;
        this.isOccupied = cell.isOccupied;
    }

    public static void printBoard(Cell[][] floor) {
        String line = "\n";
        for (int i = 0; i < floor.length; i++) {
            line += i + ": | ";
            for (int j = 0; j < floor[i].length; j++) {
                line += floor[i][j].isSeat ? floor[i][j].isOccupied ? " #" : " L" : " ." ;
            }
            line += " |\n";
        }
        line += "\n";
        System.out.println(line);
    }

    public static Integer getOccupiedSeats(Cell[][] floor) {
        int occupiedSeats = 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++)
                occupiedSeats += floor[i][j].isOccupied ? 1 : 0;
        }
        return occupiedSeats;
    }

    public Integer countOccupiedNeighbors(Cell[][] cells) {
        int occupiedNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i == row && j == column)
                    continue;
                try {
                    if (cells[i][j].isOccupied())
                        occupiedNeighbors++;
                } catch (IndexOutOfBoundsException e) {}
            }
        }

        return occupiedNeighbors;
    }

    public int countOccupiedNeighbors2(Cell[][] floor) {
        int occupiedNeighbors = 0;
        if (!floor[row][column].isSeat)
            return 0;
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                if (i == row && j == column)    // Don't test the current seat
                    continue;
                if (!floor[i][j].isSeat)        // Don't test non seats
                    continue;
                if (!isVisible(floor, i, j))    // Don't test the seats you can't see
                    continue;
                try {
                    if (floor[i][j].isOccupied()) {
                        occupiedNeighbors++;
                    }
                } catch (IndexOutOfBoundsException e) {}
            }
        }
        return occupiedNeighbors;
    }

    private boolean isVisible(Cell[][] floor, int i, int j) {
        try {
            if (i == row) {
                for (int currentColumn = Math.min(column, j) + 1; currentColumn <= Math.max(column, j); currentColumn++) {
                    if (floor[i][currentColumn].isSeat)
                        return currentColumn == column || currentColumn == j;
                }
            }
            if (j == column) {
                for (int currentRow = Math.min(row, i) + 1; currentRow <= Math.max(row, i); currentRow++) {
                    if (floor[currentRow][j].isSeat)
                        return currentRow == row || currentRow == i;
                }
            }
            if ((i - j) == (row - column)) {
                for (int index = 1; index <= Math.abs(i - row); index++) {
                    if (floor[Math.min(i, row) + index][Math.min(j, column) + index].isSeat)
                        return (Math.min(i, row) + index) == Math.max(i, row) && (Math.min(j, column) + index) == Math.max(j, column);
                }
            }
            if ((i + j) == (row + column)) {
                for (int index = 1; index <= Math.abs(i - row); index++) {
                    if (floor[Math.min(i, row) + index][Math.max(j, column) - index].isSeat)
                        return (Math.min(i, row) + index) == Math.max(i, row) && (Math.max(j, column) - index) == Math.min(j, column);
                }
            }
        } catch (IndexOutOfBoundsException e) {}
        return false;
    }

    public void toggleSeat() {
        if (isSeat) {
            this.isOccupied = !isOccupied;
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }
}
