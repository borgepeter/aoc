package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventEightTest {
    @Mock
    WebRepository webRepository;
    AdventServiceEight testService;

    private final String TEST_DATA = "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";

    @BeforeEach
    void setup() {
        testService = new AdventServiceEight(webRepository);
    }

    @Test
    void adventOne_goodInput_goodResult() {
        when(webRepository.getData(8)).thenReturn(TEST_DATA);
        assertEquals(5, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_goodInput_goodResult() {
        when(webRepository.getData(8)).thenReturn(TEST_DATA);
        assertEquals(8, testService.getAdvent2Result());
    }
}
