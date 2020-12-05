package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventTwoTest {
    @Mock
    WebRepository mockWebRepository;

    private final String TEST_DATA = "1-4 j: jjjqzmgbjwpj\n2-4 w: sckwwf\n1-13 b: bcbbbbbbbbbbhbb";

    @Test
    void getAdvent1Result_realData_correctAnswer() {
        when(mockWebRepository.getData(2)).thenReturn(TEST_DATA);

        AdventServiceTwo testService = new AdventServiceTwo(mockWebRepository);

        assertEquals(2, testService.getAdvent1Result());
    }

    @Test
    void getAdvent2Result_realData_correctAnswer() {
        when(mockWebRepository.getData(2)).thenReturn(TEST_DATA);

        AdventServiceTwo testService = new AdventServiceTwo(mockWebRepository);

        assertEquals(3, testService.getAdvent2Result());
    }
}
