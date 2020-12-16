package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdventServiceSixteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceSixteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String rawData = webRepository.getData(16);
        String[] validators = rawData.split("\n\n")[0].split("\n");
        String myTicket = rawData.split("\n\n")[1].split("\n")[1];
        String[] otherTickets = rawData.split("\n\n")[2].split("\n");
        otherTickets = Arrays.copyOfRange(otherTickets, 1, otherTickets.length);

        return 0;
    }

    public Integer getAdvent2Result() {
        return null;
    }
}
