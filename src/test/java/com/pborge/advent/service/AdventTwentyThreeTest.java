package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventTwentyThreeTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceTwentyThree testService;

    private final String TEST_INPUT = "";

    @BeforeEach
    void setup() {
        testService = new AdventServiceTwentyThree(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(23)).thenReturn(TEST_INPUT);
        assertEquals(0, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {

    }
}
