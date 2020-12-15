package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventFourteenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceFourteen testService;

    private final String TEST_INPUT = "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X\n" +
            "mem[8] = 11\n" +
            "mem[7] = 101\n" +
            "mem[8] = 0";

    private final String TEST_INPUT_2 = "mask = 000000000000000000000000000000X1001X\n" +
            "mem[42] = 100\n" +
            "mask = 00000000000000000000000000000000X0XX\n" +
            "mem[26] = 1";

    @BeforeEach
    void setup() {
        testService = new AdventServiceFourteen(webRepository);
    }

    @Test
    void adventOne_testInput_testOutput() {
        when(webRepository.getData(14)).thenReturn(TEST_INPUT);
        assertEquals(165L, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_testInput_testOutput() {
        when(webRepository.getData(14)).thenReturn(TEST_INPUT_2);
        assertEquals(208L, testService.getAdvent2Result());
    }
}
