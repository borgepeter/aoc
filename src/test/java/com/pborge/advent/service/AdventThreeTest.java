package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventThreeTest {
    @Mock
    WebRepository mockWebRepository;

    private final String TEST_SLOPE = "....\n..##\n...#\n####";
    private final String TEST_SLOPE_MEDIUM = "............\n..#..#..#..#\n.....#.....#\n............\n#####.#####.";

    @Test
    void getAdvent1Result_shortSlope_succeeds() {
        when(mockWebRepository.getData(3)).thenReturn(TEST_SLOPE);

        AdventServiceThree adventServiceThree = new AdventServiceThree(mockWebRepository);

        assertEquals(2, adventServiceThree.getTrees(3, 1));
    }

    @Test
    void getAdvent1Result_mediumSlope_succeeds() {
        when(mockWebRepository.getData(3)).thenReturn(TEST_SLOPE_MEDIUM);

        AdventServiceThree adventServiceThree = new AdventServiceThree(mockWebRepository);

        assertEquals(1, adventServiceThree.getTrees(3, 1));
    }

    @Test
    void getAdvent1Result_shortSlopeDiagonal_succeeds() {
        when(mockWebRepository.getData(3)).thenReturn(TEST_SLOPE);

        AdventServiceThree adventServiceThree = new AdventServiceThree(mockWebRepository);

        assertEquals(1, adventServiceThree.getTrees(1, 1));
    }

    @Test
    void getAdvent1Result_mediumSlopeWide_succeeds() {
        when(mockWebRepository.getData(3)).thenReturn(TEST_SLOPE_MEDIUM);

        AdventServiceThree adventServiceThree = new AdventServiceThree(mockWebRepository);

        assertEquals(1, adventServiceThree.getTrees(7, 1));
    }

    @Test
    void getAdvent2Result_mediumSlopeWide_succeeds() {
        when(mockWebRepository.getData(3)).thenReturn(TEST_SLOPE_MEDIUM);

        AdventServiceThree adventServiceThree = new AdventServiceThree(mockWebRepository);

        assertEquals(2, adventServiceThree.getAdvent2Result());
    }
}
