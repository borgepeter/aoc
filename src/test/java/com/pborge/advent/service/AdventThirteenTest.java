package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventThirteenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceThirteen testService;

    private final String TEST_INPUT = "939\n" +
            "7,13,x,x,59,x,31,19";

    @BeforeEach
    void setup() {
        testService = new AdventServiceThirteen(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(13)).thenReturn(TEST_INPUT);
        assertEquals(295, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {

    }
}
