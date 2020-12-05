package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdventServiceOne {
    @Autowired
    private WebRepository webRepository;
    private final String URL = "1/input";

    public int getAdvent1Result() {
        final int TARGET = 2020;
        List<String> strings = Arrays.asList(webRepository.getData(1).split("\n"));
        List<Integer> integers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        int a = 0;

        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(a) + integers.get(i) == TARGET) {
                System.out.println("A: " + integers.get(a) + ", B: " + integers.get(i));
                return integers.get(a) * integers.get(i);
            }

            if (i + 1 == integers.size()) {
                if (a + 1 == integers.size())
                    throw new RuntimeException("Can't find the number in this data set.");

                a++;
                i = a + 1;
            }
        }

        throw new RuntimeException("Not sure how we got here");
    }

    public int getAdvent2Result() {
        final int TARGET = 2020;
        List<String> strings = Arrays.asList(webRepository.getData(1).split("\n"));
        List<Integer> integers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
        int a = 0;

        for (int i = 1; i < integers.size(); i++) {
            for (int j = 2; j < integers.size(); j++) {
                if (integers.get(a) + integers.get(i) + integers.get(j) == TARGET) {
                    System.out.println("A: " + integers.get(a) + ", B: " + integers.get(i) + ", C: " + integers.get(j));
                    return integers.get(a) * integers.get(i) * integers.get(j);
                }

                if (i + 2 == integers.size()) {
                    if (a + 2 == integers.size())
                        throw new RuntimeException("Can't find the number in this data set.");

                    a++;
                    i = a + 1;
                }

                if (j + 1 == integers.size()) {
                    i++;
                    j = a + 2;
                }
            }
        }

        throw new RuntimeException("Not sure how we got here");
    }
}
