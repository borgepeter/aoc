package com.pborge.advent.models;

public class Waypoint {
    private int x = 10;
    private int y = 1;

    public void update(String directions) {
        int amount = Integer.parseInt(directions.substring(1));
        String instruction = directions.split("")[0];

        try {
            Boat.DIRECTION direction = Boat.DIRECTION.valueOf(instruction);
            move(direction, amount);
        } catch (IllegalArgumentException e) {}

        try {
            Boat.ROTATION r = Boat.ROTATION.valueOf(instruction);
            if (amount == 180) {
                x *= -1;
                y *= -1;
            } else {
                switch (r) {
                    case L:
                        switch ((amount / 90) % 4) {
                            case 1:
                                rotateLeft();
                                break;
                            case 3:
                                rotateRight();
                                break;
                        }
                        break;
                    case R:
                        switch ((amount / 90) % 4) {
                            case 1:
                                rotateRight();
                                break;
                            case 3:
                                rotateLeft();
                                break;

                        }
                        break;
                }
            }
        } catch (IllegalArgumentException e) {}
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void move(Boat.DIRECTION direction, int amount) {
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

    private void rotateLeft() {
        int temp = x;
        x = y * -1;
        y = temp;
    }

    private void rotateRight() {
        int temp = x;
        x = y;
        y = temp * -1;
    }
}
