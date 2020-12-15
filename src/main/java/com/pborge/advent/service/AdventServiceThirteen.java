package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdventServiceThirteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceThirteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] data = webRepository.getData(13).split("\n");
        int departureTime = Integer.parseInt(data[0]);
        List<Integer> busIds = Arrays.stream(data[1].split(","))
                .filter(s -> !"x".equalsIgnoreCase(s))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int selectedBusId = -1;
        int waitTime = 9999999;
        for (Integer busId : busIds) {
            int waitForBus = ((departureTime / busId) * busId + busId) - departureTime;
            if (waitTime > waitForBus) {
                selectedBusId = busId;
                waitTime = waitForBus;
            }
        }

        return selectedBusId * waitTime;
    }

    public Integer getAdvent2Result() {
        return null;
    }
}
