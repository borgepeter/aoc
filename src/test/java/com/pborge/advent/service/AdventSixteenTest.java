package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventSixteenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceSixteen testService;

    private final String TEST_INPUT = "class: 1-3 or 5-7\n" +
            "row: 6-11 or 33-44\n" +
            "seat: 13-40 or 45-50\n" +
            "\n" +
            "your ticket:\n" +
            "7,1,14\n" +
            "\n" +
            "nearby tickets:\n" +
            "7,3,47\n" +
            "40,4,50\n" +
            "55,2,20\n" +
            "38,6,12";

    @BeforeEach
    void setup() {
        testService = new AdventServiceSixteen(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(16)).thenReturn(TEST_INPUT);
        assertEquals(71, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {

    }
}
