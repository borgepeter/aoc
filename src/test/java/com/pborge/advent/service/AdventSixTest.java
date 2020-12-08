package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventSixTest {
    @Mock
    WebRepository webRepository;

    AdventServiceSix testService;

    private final String CUSTOMS_INFO = "abc\n" +
            "\n" +
            "a\n" +
            "b\n" +
            "c\n" +
            "\n" +
            "ab\n" +
            "ac\n" +
            "\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "\n" +
            "b";

    @BeforeEach
    void setup() {
        testService = new AdventServiceSix(webRepository);
    }

    @Test
    void getCustomsCount1_goodData_countReturned() {
        when(webRepository.getData(6)).thenReturn(CUSTOMS_INFO);
        assertEquals(11, testService.getAdvent1Result());
    }

    @Test
    void getCustomsCount2_goodData_countReturned() {
        when(webRepository.getData(6)).thenReturn(CUSTOMS_INFO);
        assertEquals(6, testService.getAdvent2Result());
    }
}
