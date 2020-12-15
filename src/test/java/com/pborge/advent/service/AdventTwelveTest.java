package com.pborge.advent.service;

import com.pborge.advent.models.Boat;
import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventTwelveTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceTwelve testService;

    private final String TEST_INPUT = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";

    @BeforeEach
    void setup() {
        testService = new AdventServiceTwelve(webRepository);
    }

    @Test
    void adventOne_rotate() {
        String rotate = "R90\nF1";
        when(webRepository.getData(12)).thenReturn(rotate);
        testService.getAdvent1Result();
        assertEquals(Boat.DIRECTION.S, testService.boat.getDirection());
    }

    @Test
    void adventOne_rotateTwo() {
        String rotate = "L90\nF1";
        when(webRepository.getData(12)).thenReturn(rotate);
        testService.getAdvent1Result();
        assertEquals(Boat.DIRECTION.N, testService.boat.getDirection());
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(12)).thenReturn(TEST_INPUT);
        assertEquals(25, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {
        when(webRepository.getData(12)).thenReturn(TEST_INPUT);
        assertEquals(286, testService.getAdvent2Result());
    }
}
