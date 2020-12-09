package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventNineTest {
    @Mock
    WebRepository webRepository;
    AdventServiceNine testService;

    private final String TEST_DATA = "35\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "47\n" +
            "40\n" +
            "62\n" +
            "55\n" +
            "65\n" +
            "95\n" +
            "102\n" +
            "117\n" +
            "150\n" +
            "182\n" +
            "127\n" +
            "219\n" +
            "299\n" +
            "277\n" +
            "309\n" +
            "576";

    @BeforeEach
    void setup() {
        testService = spy(new AdventServiceNine(webRepository));
    }

    @Test
    void adventOne_goodInput_goodResult() {
        when(webRepository.getData(9)).thenReturn(TEST_DATA);
        when(testService.getPreambleLength()).thenReturn(5);
        assertEquals(127l, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_goodInput_goodResult() {
        when(webRepository.getData(9)).thenReturn(TEST_DATA);
        when(testService.getPreambleLength()).thenReturn(5);
        assertEquals(62l, testService.getAdvent2Result());
    }
}
