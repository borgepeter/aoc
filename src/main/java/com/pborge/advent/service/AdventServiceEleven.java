package com.pborge.advent.service;

import com.pborge.advent.models.Cell;
import com.pborge.advent.models.Floor;
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
        Floor floor = createFloor();
        return runSimulation(floor, 0, 4, false);
    }

    public Integer getAdvent2Result() {
        Floor floor = createFloor();
        return runSimulation(floor, 0, 5, true);
    }

    private int runSimulation(Floor floor, int minSpontaneousLife, int maxOvercrowdDeath, boolean skipEmptySeats) {
        int seatsLastTime = -1;
        int counter = 0;

        floor.print();
        while (true) {
            floor = step(floor, minSpontaneousLife, maxOvercrowdDeath, skipEmptySeats);
            Integer occupiedSeats = floor.getOccupiedSeats();
            floor.print();

            if (occupiedSeats == seatsLastTime)
                return occupiedSeats;

            if (counter > 1000)
                throw new RuntimeException("Infinite Loop Suspected");

            seatsLastTime = occupiedSeats;
            counter++;
        }

    }

    private Floor step(Floor floor, int minSpontaneousLife, int maxOvercrowdDeath, boolean skipEmptySeats) {
        Floor nextFloor = new Floor(floor.getWidth(), floor.getHeight());
        for (int i = 0; i < floor.getWidth(); i++) {
            for (int j = 0; j < floor.getHeight(); j++) {
                nextFloor.add(new Cell(floor.get(i, j)), i, j);
                int occupiedNeighbors = floor.countOccupiedNeighbors(i, j, skipEmptySeats);
                if (!floor.get(i, j).isOccupied() && occupiedNeighbors == minSpontaneousLife)
                    nextFloor.get(i, j).toggleSeat();
                if (floor.get(i, j).isOccupied() && occupiedNeighbors >= maxOvercrowdDeath)
                    nextFloor.get(i, j).toggleSeat();
            }
        }

        return nextFloor;
    }

    private Floor createFloor() {
        String[] data = webRepository.getData(11).split("\n");
        Floor floor = new Floor(data.length, data[0].length());
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                floor.add(new Cell(data[i].split("")[j]), i, j);
            }
        }
        return floor;
    }
}
