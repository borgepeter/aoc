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
        when(webRepository.getData(13)).thenReturn(TEST_INPUT);
        assertEquals(1068781, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput2_testOutput() {
        when(webRepository.getData(13)).thenReturn("\n17,x,13,19");
        assertEquals(3417, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput3_testOutput() {
        when(webRepository.getData(13)).thenReturn("\n67,7,59,61");
        assertEquals(754018, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput4_testOutput() {
        when(webRepository.getData(13)).thenReturn("\n67,x,7,59,61");
        assertEquals(779210, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput5_testOutput() {
        when(webRepository.getData(13)).thenReturn("\n67,7,x,59,61");
        assertEquals(1261476, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput6_testOutput() {
        when(webRepository.getData(13)).thenReturn("\n1789,37,47,1889");
        assertEquals(1202161486, testService.getAdvent2Result());
    }
}
