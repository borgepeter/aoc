package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdventServiceFifteen {
    @Autowired
    private final WebRepository webRepository;

    public AdventServiceFifteen(WebRepository webRepository) {
        this.webRepository = webRepository;
    }

    public Integer getAdvent1Result() {
        return rambunctiousRecitation(2020);
    }

    public Integer getAdvent2Result() {
        return rambunctiousRecitation(30000000);
    }

    private Integer rambunctiousRecitation(int target) {
        List<Integer> input = Arrays.stream(webRepository.getData(15).split("\n")[0].split(",")).map(Integer::parseInt).collect(Collectors.toList());
        Map<Integer, Integer> spokenNumbers = new HashMap<>();
        Integer[] output = new Integer[target + 1];
        int counter = 0;
        while (counter < target + 1) {
            int lastNumber = counter > 0 ? output[counter - 1] : -1;

            int nextNumber = 0;
            if (input.size() > counter)
                nextNumber = input.get(counter);
            else if (spokenNumbers.containsKey(lastNumber))
                nextNumber = counter - spokenNumbers.get(lastNumber);

            output[counter] = nextNumber;
            if (counter > 0)
                spokenNumbers.put(lastNumber,  counter);
            counter++;
        }
        return output[target - 1];
    }
}
