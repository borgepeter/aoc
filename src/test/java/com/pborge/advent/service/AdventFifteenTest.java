package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventFifteenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceFifteen testService;

    private final String TEST_INPUT = "0,3,6";
    private final String TEST_INPUT_2 = "1,3,2";
    private final String TEST_INPUT_3 = "2,1,3";
    private final String TEST_INPUT_4 = "1,2,3";
    private final String TEST_INPUT_5 = "2,3,1";
    private final String TEST_INPUT_6 = "3,2,1";
    private final String TEST_INPUT_7 = "3,1,2";
    private final String ACTUAL_INPUT = "16,1,0,18,12,14,19";

    @BeforeEach
    void setup() {
        testService = new AdventServiceFifteen(webRepository);
    }

    @Test
    void adventOne_actualInput_realOutput() {
        when(webRepository.getData(15)).thenReturn(ACTUAL_INPUT);
        assertEquals(929, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_actualInput_realOutput() {
        when(webRepository.getData(15)).thenReturn(ACTUAL_INPUT);
        assertEquals(0, testService.getAdvent2Result());
    }

    @Test
    void adventOne_testInput1_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT);
        assertEquals(436, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput2_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_2);
        assertEquals(1, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput3_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_3);
        assertEquals(10, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput4_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_4);
        assertEquals(27, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput5_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_5);
        assertEquals(78, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput6_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_6);
        assertEquals(438, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput7_testOutput() {
        when(webRepository.getData(15)).thenReturn(TEST_INPUT_7);
        assertEquals(1836, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {

    }
}
