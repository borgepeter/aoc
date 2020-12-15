package com.pborge.advent.models;

public class Boat {
    public enum DIRECTION {
        E,  // East
        S,  // South
        W,  // West
        N   // North
    }

    public enum ROTATION {
        F,  // Forward
        L,  // Left
        R   // Right
    }

    private DIRECTION direction = DIRECTION.E;
    private int x = 0;
    private int y = 0;

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    public void move(String directions) {
        int amount = Integer.parseInt(directions.substring(1));
        String instruction = directions.split("")[0];

        try {
            DIRECTION direction = DIRECTION.valueOf(instruction);
            move(direction, amount);
        } catch (IllegalArgumentException e) {}

        try {
            ROTATION r = ROTATION.valueOf(instruction);
            switch (r) {
                case F:
                    move(this.direction, amount);
                    break;
                case L:
                    this.direction = DIRECTION.values()[(this.direction.ordinal() + 4 - (amount / 90)) % 4];
                    break;
                case R:
                    this.direction = DIRECTION.values()[(this.direction.ordinal() + (amount / 90)) % 4];
                    break;
            }
        } catch (IllegalArgumentException e) {}
    }

    public void move(int amount, Waypoint waypoint) {
        for (int i = 0; i < amount; i++) {
            this.x += waypoint.getX();
            this.y += waypoint.getY();
        }
    }

    private void move(DIRECTION direction, int amount) {
        switch (direction) {
            case E:
                this.x += amount;
                break;
            case S:
                this.y -= amount;
                break;
            case W:
                this.x -= amount;
                break;
            case N:
                this.y += amount;
                break;
        }
    }

    public DIRECTION getDirection() {
        return this.direction;
    }
}
