package com.pborge.advent.service;

import com.pborge.advent.models.Cell;
import com.pborge.advent.models.Cube;
import com.pborge.advent.models.Floor;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    private Cube createCube() {
        String[] rawData = webRepository.getData(17).split("\n");
        Cube cube = new Cube(rawData.length, rawData[0].split("").length, BOOT_CYCLES + 1);
        for (int z = 0; z <= BOOT_CYCLES; z++) {
            for (int x = 0; x < cube.getFloor(0).getWidth(); x++) {
                for (int y = 0; y < cube.getFloor(0).getHeight(); y++) {
                    String cellData = z == 0 ? rawData[x].split("")[y].replace(".", "L") : "L";
                    cube.add(new Cell(cellData), x, y, z);
                }
            }
        }

        return cube;
    }

    private Cube step(Cube cube, int spontaneousLife, int minOvercrowdDeath, int maxOvercrowdDeath) {
        Cube nextCube = new Cube(cube.getWidth() + 2, cube.getHeight() + 2, cube.getDepth());
        for (int z = 0; z < cube.getDepth(); z++) {
            Floor nextFloor = new Floor(nextCube.getWidth(), nextCube.getHeight());
            for (int x = 0; x < nextCube.getWidth(); x++) {
                for (int y = 0; y < nextCube.getHeight(); y++) {
                    int occupiedNeighbors = cube.countOccupiedNeighbors(x, y, z);
                    boolean isOccupied = x < cube.getWidth() && y < cube.getHeight() && cube.getFloor(z).get(x, y).isOccupied();
                    if (isOccupied && (occupiedNeighbors < minOvercrowdDeath || occupiedNeighbors > maxOvercrowdDeath)) {
                        isOccupied = false;
                        //System.out.println("Cell ["+x+", "+y+", "+z+"] becomes empty with "+occupiedNeighbors+" neighbors");
                    }
                    else if (!isOccupied && occupiedNeighbors == spontaneousLife) {
                        isOccupied = true;
                        //System.out.println("Cell ["+x+", "+y+", "+z+"] comes to life with "+occupiedNeighbors+" neighbors");
                    } else if (isOccupied) {
                        //System.out.println("Cell ["+x+", "+y+", "+z+"] remains occupied with "+occupiedNeighbors+" neighbors");
                    }

                    if (isOccupied)
                        nextFloor.add(new Cell("#"), x + 1, y + 1);
                }
            }
            nextCube.add(nextFloor, z);
        }

        return nextCube;
    }
}
