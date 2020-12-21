package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventEighteenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceEighteen testService;

    private final String TEST_INPUT_1 = "1 + 2 * 3 + 4 * 5 + 6";
    private final String TEST_INPUT_2 = "1 + (2 * 3) + (4 * (5 + 6))";
    private final String TEST_INPUT_3 = "2 * 3 + (4 * 5)";
    private final String TEST_INPUT_4 = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
    private final String TEST_INPUT_5 = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
    private final String TEST_INPUT_6 = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";

    @BeforeEach
    void setup() {
        testService = new AdventServiceEighteen(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_1);
        assertEquals(71, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput2_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_2);
        assertEquals(51, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput3_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_3);
        assertEquals(26, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput4_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_4);
        assertEquals(437, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput5_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_5);
        assertEquals(12240, testService.getAdvent1Result());
    }

    @Test
    void adventOne_testInput6_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_6);
        assertEquals(13632, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_1);
        assertEquals(231, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput2_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_2);
        assertEquals(51, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput3_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_3);
        assertEquals(46, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput4_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_4);
        assertEquals(1445, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput5_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_5);
        assertEquals(669060, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_testInput6_testOutput() {
        when(webRepository.getData(18)).thenReturn(TEST_INPUT_6);
        assertEquals(23340, testService.getAdvent2Result());
    }
}
