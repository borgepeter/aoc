package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventTenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceTen testService;

    private final String TEST_INPUT_1 = "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4";

    private final String TEST_INPUT_2 = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

    @BeforeEach
    void setup() {
        testService = new AdventServiceTen(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(10)).thenReturn(TEST_INPUT_1);
        assertEquals(35, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput2_testOutput() {
        when(webRepository.getData(10)).thenReturn(TEST_INPUT_2);
        assertEquals(220, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {
        when(webRepository.getData(10)).thenReturn(TEST_INPUT_1);
        assertEquals(8, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput2_testOutput() {
        when(webRepository.getData(10)).thenReturn(TEST_INPUT_2);
        assertEquals(19208, testService.getAdvent2Result());
    }
}
