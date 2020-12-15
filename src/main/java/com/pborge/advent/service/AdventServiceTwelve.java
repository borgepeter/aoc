package com.pborge.advent.service;

import com.pborge.advent.models.Boat;
import com.pborge.advent.models.Waypoint;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventServiceTwelve {
    @Autowired
    private final WebRepository webRepository;

    protected Boat boat;
    protected Waypoint waypoint;

    public AdventServiceTwelve(WebRepository webRepository) {
        this.webRepository = webRepository;
        this.boat = new Boat();
        this.waypoint = new Waypoint();
    }

    public Integer getAdvent1Result() {
        String[] data = webRepository.getData(12).split("\n");
        for (String instruction: data)
            boat.move(instruction);

        return boat.getManhattanDistance();
    }

    public Integer getAdvent2Result() {
        String[] data = webRepository.getData(12).split("\n");
        for (String instruction: data) {
            if (instruction.contains("F"))
                boat.move(Integer.parseInt(instruction.substring(1)), waypoint);
            else
                waypoint.update(instruction);
        }
        return boat.getManhattanDistance();
    }
}
