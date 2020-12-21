package com.pborge.advent.models;

public class HyperCube extends Cube {
    private Cube[] cubes;

    public HyperCube(int width, int height, int depth, int time) {
        super(width, height, depth);
        cubes = new Cube[time];
        for (int n = 0; n < time; n++)
            cubes[n] = new Cube(width, height, depth);

        for (int n = 0; n < time; n++) {
            for (int z = 0; z < cubes.length; z++) {
                for (int x = 0; x < cubes[z].getWidth(); x++) {
                    for (int y = 0; y < cubes[z].getHeight(); y++) {
                        add(new Cell("L"), x, y, z, n);
                    }
                }
            }
        }
    }

    public int getWidth() {
        if (cubes == null)
            return 0;
        return cubes[0].getWidth();
    }

    public int getHeight() {
        if (cubes == null)
            return 0;
        return cubes[0].getHeight();
    }

    public int getDepth() {
        if (cubes == null)
            return 0;
        return cubes[0].getDepth();
    }

    public int getTime() {
        if (cubes == null)
            return 0;
        return cubes.length;
    }

    public void add(Cell cell, int x, int y, int z, int n) {
        cubes[n].getFloor(z).add(cell, x, y);
    }

    public void add(Cube cube, int n) {
        cubes[n] = cube;
    }

    public Cube getCube(int n) {
        return cubes[n];
    }

    public Integer getOccupiedSeats() {
        int sum = 0;
        for (int n = 0; n < cubes.length; n++) {
            if (n != 0) // We're extending in both directions, so count everything but the ground floor twice
                sum += cubes[n].getOccupiedSeats();
            sum += cubes[n].getOccupiedSeats();
        }
        return sum;
    }

    public void print() {
        for (int n = 0; n < cubes.length; n++) {
            for (int z = 0; z < cubes[n].getDepth(); z++) {
                if (cubes[n].getOccupiedSeats() > 0) {
                    System.out.println("N: " + n + (n > 9 ? "" : " ") + ".");
                    cubes[n].print();
                }
            }
        }
    }

    public int countOccupiedNeighbors(int row, int column, int level, int time) {
        int occupiedNeighbors = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    int testLevel = level + (level > 0 ? (k - 1) : Math.min(k, 1));
                    for (int l = 0; l <= 2; l++) {
                        int testTime = time + (time > 0 ? (l - 1) : Math.min(l, 1));
                        if (i == row && j == column && testLevel == level && testTime == time)
                            continue;
                        try {
                            if (getCube(testTime).getFloor(testLevel).get(i, j).isOccupied()) {
                                occupiedNeighbors++;
                            }
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                }
            }
        }

        return occupiedNeighbors;
    }
}
