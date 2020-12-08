package com.pborge.advent.service;

import com.pborge.advent.models.Seat;
import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AdventServiceFive {
    @Autowired
    private final WebRepository webRepository;
    private final int MAX_ROWS = 127;

    public AdventServiceFive(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        List<String> seatData = Arrays.asList(webRepository.getData(5).split("\n"));
        List<Seat> seats = seatData.stream().map(this::getSeat).collect(Collectors.toList());
        return seats.stream().map(Seat::getId).max(Integer::compare).get();
    }

    public Integer getAdvent2Result() {
        List<String> seatData = Arrays.asList(webRepository.getData(5).split("\n"));
        Map<Integer, Seat> seats = seatData.stream().map(this::getSeat).collect(Collectors.toMap(Seat::getId, Function.identity()));

         for (int i = 0; i < 1024; i++) {
            if (seats.containsKey(i-1) && !seats.containsKey(i) && seats.containsKey(i+1))
                return i;
        }

        throw new RuntimeException("Unable to find seat!");
    }

    protected Seat getSeat(String seatRawData) {
        int row = findRowColumn(seatRawData.substring(0, 7), "F");
        int column = findRowColumn(seatRawData.substring(7), "L");
        return new Seat(row, column, (row * 8) + column);
    }

    protected int findRowColumn(String rawData, String character) {
        String[] directions = rawData.split("");
        int rowMin = 0;
        double rowMax = Math.pow(2, directions.length) - 1;
        for (int i = 0; i < directions.length - 1; i++) {
            double half = Math.pow(2, directions.length - i - 1);
            if (character.equalsIgnoreCase(directions[i])) {
                rowMax -= half;
            } else {
                rowMin += half;
            }
        }
        return (int) Math.round(character.equalsIgnoreCase(directions[directions.length - 1]) ? rowMin : rowMax);
    }
}
