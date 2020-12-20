package com.pborge.advent.models;

public class Cube {
    private Floor[] floors;

    public Cube(int width, int height, int depth) {
        floors = new Floor[depth];
        for (int z = 0; z < depth; z++)
            floors[z] = new Floor(width, height);
    }

    public int getWidth() {
        if (floors == null)
            return 0;
        return floors[0].getWidth();
    }

    public int getHeight() {
        if (floors == null)
            return 0;
        return floors[0].getHeight();
    }

    public int getDepth() {
        if (floors == null)
            return 0;
        return floors.length;
    }

    public void add(Cell cell, int x, int y, int z) {
        floors[z].add(cell, x, y);
    }

    public void add(Floor floor, int z) {
        floors[z] = floor;
    }

    public Floor getFloor(int z) {
        return floors[z];
    }

    public Integer getOccupiedSeats() {
        int sum = 0;
        for (int z = 0; z < floors.length; z++) {
            if (z != 0) // We're extending in both directions, so count everything but the ground floor twice
                sum += floors[z].getOccupiedSeats();
            sum += floors[z].getOccupiedSeats();
        }
        return sum;
    }

    public void print() {
        for (int z = 0; z < floors.length; z++) {
            if (floors[z].getOccupiedSeats() > 0) {
                System.out.println(z + (z > 9 ? "" : " ") + ".");
                floors[z].print();
            }
        }
    }

    public int countOccupiedNeighbors(int row, int column, int level) {
        int occupiedNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    int testLevel = level + (level > 0 ? (k - 1) : Math.min(k, 1));
                    if (i == row && j == column && testLevel == level)
                        continue;
                    try {
                        if (getFloor(testLevel).get(i, j).isOccupied()) {
                            occupiedNeighbors++;
                        }
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }

        return occupiedNeighbors;
    }
}
