package com.pborge.advent.service;

import com.pborge.advent.models.Cell;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventServiceEleven {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceEleven(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        Cell[][] floor = createFloor();
        int seatsLastTime = -1;
        int counter = 0;
        Cell.printBoard(floor);
        while (true) {
            floor = step1(floor);
            Integer occupiedSeats = Cell.getOccupiedSeats(floor);
            Cell.printBoard(floor);

            if (occupiedSeats == seatsLastTime)
                return occupiedSeats;

            seatsLastTime = occupiedSeats;
        }
    }

    public Integer getAdvent2Result() {
        Cell[][] floor = createFloor();
        int seatsLastTime = -1;
        int counter = 0;
        Cell.printBoard(floor);
        while (true) {
            floor = step2(floor);
            Integer occupiedSeats = Cell.getOccupiedSeats(floor);
            Cell.printBoard(floor);

            if (occupiedSeats == seatsLastTime)
                return occupiedSeats;

            if (counter > 1000)
                throw new RuntimeException("Infinite Loop Suspected");

            seatsLastTime = occupiedSeats;
            counter++;
        }
    }

    private Cell[][] step1(Cell[][] floor) {
        Cell[][] nextFloor = new Cell[floor.length][floor[0].length];
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                nextFloor[i][j] = new Cell(floor[i][j]);
                int occupiedNeighbors = floor[i][j].countOccupiedNeighbors(floor);
                if (!floor[i][j].isOccupied() && occupiedNeighbors == 0)
                    nextFloor[i][j].toggleSeat();
                if (floor[i][j].isOccupied() && occupiedNeighbors >= 4)
                    nextFloor[i][j].toggleSeat();
            }
        }

        return nextFloor;
    }

    private Cell[][] step2(Cell[][] floor) {
        Cell[][] nextFloor = new Cell[floor.length][floor[0].length];
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                nextFloor[i][j] = new Cell(floor[i][j]);
                int occupiedNeighbors = floor[i][j].countOccupiedNeighbors2(floor);
                if (!floor[i][j].isOccupied() && occupiedNeighbors == 0)
                    nextFloor[i][j].toggleSeat();
                if (floor[i][j].isOccupied() && occupiedNeighbors >= 5)
                    nextFloor[i][j].toggleSeat();
            }
        }

        return nextFloor;
    }

    private Cell[][] createFloor() {
        String[] data = webRepository.getData(11).split("\n");
        Cell[][] floor = new Cell[data.length][data[0].length()];
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                floor[i][j] = new Cell(data[i].split("")[j], i, j);
            }
        }
        return floor;
    }
}
