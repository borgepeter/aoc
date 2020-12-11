package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdventServiceTen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceTen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        String[] rawData = webRepository.getData(10).split("\n");
        Set<Integer> orderedData = Arrays.stream(rawData).map(Integer::parseInt).collect(Collectors.toCollection(TreeSet::new));
        Map<Integer, Integer> joltageDifference = getJoltageDifference(orderedData);

        return joltageDifference.get(1) * (joltageDifference.get(3) + 1);
    }

    public Long getAdvent2Result() {
        String[] rawData = webRepository.getData(10).split("\n");
        Integer[] orderedData = Arrays.stream(rawData).map(Integer::parseInt).collect(Collectors.toCollection(TreeSet::new)).toArray(new Integer[rawData.length]);
        long combinations = 1L;
        long streak = 0;
        int last = 0;
        for (Integer orderedDatum : orderedData) {
            if (orderedDatum - last == 1)
                streak++;
            else {
                combinations *= calculateCombinations(streak);
                streak = 0;
            }
            last = orderedDatum;
        }

        return combinations * calculateCombinations(streak);
    }

    private Map<Integer, Integer> getJoltageDifference(Set<Integer> orderedData) {
        Map<Integer, Integer> joltageDifference = new HashMap<>();
        int last = 0;
        for (Integer i : orderedData) {
            int difference = i - last;
            joltageDifference.put(difference, joltageDifference.getOrDefault(difference, 0) + 1);
            last = i;
        }
        return joltageDifference;
    }

    private long calculateCombinations(Long streak) {
        streak--;
        return (streak * streak + streak + 2) / 2;
    }
}
