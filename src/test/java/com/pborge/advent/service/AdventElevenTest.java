package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventElevenTest {
    @Mock
    private WebRepository webRepository;

    private AdventServiceEleven testService;

    private final String TEST_1 = "L.LL.LL.LL\n" +
            "LLLLLLL.LL\n" +
            "L.L.L..L..\n" +
            "LLLL.LL.LL\n" +
            "L.LL.LL.LL\n" +
            "L.LLLLL.LL\n" +
            "..L.L.....\n" +
            "LLLLLLLLLL\n" +
            "L.LLLLLL.L\n" +
            "L.LLLLL.LL";

    @BeforeEach
    void setup() {
        testService = new AdventServiceEleven(webRepository);
    }

    @Test
    void getAdvent1Result_testInput_expectedResult() {
        when(webRepository.getData(11)).thenReturn(TEST_1);
        assertEquals(37, testService.getAdvent1Result());
    }

    @Test
    void getAdvent2Result_testInput_expectedResult() {
        when(webRepository.getData(11)).thenReturn(TEST_1);
        assertEquals(26, testService.getAdvent2Result());
    }

}
