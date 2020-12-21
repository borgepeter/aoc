package com.pborge.advent.service;

import com.pborge.advent.models.Cell;
import com.pborge.advent.models.Cube;
import com.pborge.advent.models.Floor;
import com.pborge.advent.models.HyperCube;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdventServiceSeventeen {
    @Autowired
    private final WebRepository webRepository;

    private final int BOOT_CYCLES = 6;

    public AdventServiceSeventeen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        Cube cube = createCube();
        cube.print();

        for (int i = 0; i < BOOT_CYCLES; i++) {
            cube = step(cube, 3, 2, 3);
            cube.print();
        }

        return cube.getOccupiedSeats();
    }

    public Integer getAdvent2Result() {
        HyperCube hyperCube = createHyperCube();
        hyperCube.print();

        for (int i = 0; i < BOOT_CYCLES; i++) {
            hyperCube = step2(hyperCube, 3, 2, 3);
            hyperCube.print();
        }

        return hyperCube.getOccupiedSeats();
    }

    private HyperCube createHyperCube() {
        String[] rawData = webRepository.getData(17).split("\n");
        int width = rawData.length + BOOT_CYCLES * 2;
        int length = rawData[0].split("").length + BOOT_CYCLES * 2;
        HyperCube hyperCube = new HyperCube(width, length, BOOT_CYCLES + 1, BOOT_CYCLES + 1);

        for (int x = 0; x < rawData.length; x++) {
            for (int y = 0; y < rawData[x].split("").length; y++) {
                String cellData = rawData[x].split("")[y].replace(".", "L");
                hyperCube.add(new Cell(cellData), x + BOOT_CYCLES, y + BOOT_CYCLES, 0, 0);
            }
        }

        return hyperCube;
    }

    private Cube createCube() {
        String[] rawData = webRepository.getData(17).split("\n");
        int width = rawData.length + BOOT_CYCLES * 2;
        int length = rawData[0].split("").length + BOOT_CYCLES * 2;
        Cube cube = new Cube(width, length, BOOT_CYCLES + 1);

        for (int x = 0; x < rawData.length; x++) {
            for (int y = 0; y < rawData[x].split("").length; y++) {
                String cellData = rawData[x].split("")[y].replace(".", "L");
                cube.add(new Cell(cellData), x + BOOT_CYCLES, y + BOOT_CYCLES, 0);
            }
        }

        return cube;
    }

    private Cube step(Cube cube, int spontaneousLife, int minOvercrowdDeath, int maxOvercrowdDeath) {
        Cube nextCube = new Cube(cube.getWidth(), cube.getHeight(), cube.getDepth());
        for (int z = 0; z < cube.getDepth(); z++) {
            Floor nextFloor = new Floor(nextCube.getWidth(), nextCube.getHeight());
            for (int x = 0; x < nextCube.getWidth(); x++) {
                for (int y = 0; y < nextCube.getHeight(); y++) {
                    int occupiedNeighbors = cube.countOccupiedNeighbors(x, y, z);
                    boolean isOccupied = cube.getFloor(z).get(x, y).isOccupied();
                    if (isOccupied && (occupiedNeighbors < minOvercrowdDeath || occupiedNeighbors > maxOvercrowdDeath)) {
                        isOccupied = false;
                    }
                    else if (!isOccupied && occupiedNeighbors == spontaneousLife) {
                        isOccupied = true;
                    }

                    if (isOccupied)
                        nextFloor.add(new Cell("#"), x, y);
                }
            }
            nextCube.add(nextFloor, z);
        }

        return nextCube;
    }

    private HyperCube step2(HyperCube hyperCube, int spontaneousLife, int minOvercrowdDeath, int maxOvercrowdDeath) {
        HyperCube nextHyperCube = new HyperCube(hyperCube.getWidth(), hyperCube.getHeight(), hyperCube.getDepth(), hyperCube.getTime());
        for (int n = 0; n < hyperCube.getTime(); n++) {
            Cube nextCube = new Cube(hyperCube.getWidth(), hyperCube.getHeight(), hyperCube.getDepth());
            for (int z = 0; z < hyperCube.getDepth(); z++) {
                Floor nextFloor = new Floor(hyperCube.getWidth(), hyperCube.getHeight());
                for (int x = 0; x < hyperCube.getWidth(); x++) {
                    for (int y = 0; y < hyperCube.getHeight(); y++) {
                        int occupiedNeighbors = hyperCube.countOccupiedNeighbors(x, y, z, n);
                        boolean isOccupied = hyperCube.getCube(n).getFloor(z).get(x, y).isOccupied();
                        if (isOccupied && (occupiedNeighbors < minOvercrowdDeath || occupiedNeighbors > maxOvercrowdDeath)) {
                            isOccupied = false;
                        } else if (!isOccupied && occupiedNeighbors == spontaneousLife) {
                            isOccupied = true;
                        }

                        if (isOccupied)
                            nextFloor.add(new Cell("#"), x, y);
                    }
                }
                nextCube.add(nextFloor, z);
            }
            nextHyperCube.add(nextCube, n);
        }

        return nextHyperCube;
    }
}
