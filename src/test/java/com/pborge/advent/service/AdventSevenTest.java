package com.pborge.advent.service;

import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdventSevenTest {
    @Mock
    WebRepository webRepository;

    AdventServiceSeven testService;

    private final String TEST_BAGS = "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
            "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
            "bright white bags contain 1 shiny gold bag.\n" +
            "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
            "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
            "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
            "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
            "faded blue bags contain no other bags.\n" +
            "dotted black bags contain no other bags.";

    private final String TEST_BAGS_2 = "shiny gold bags contain 2 dark red bags.\n" +
            "dark red bags contain 2 dark orange bags.\n" +
            "dark orange bags contain 2 dark yellow bags.\n" +
            "dark yellow bags contain 2 dark green bags.\n" +
            "dark green bags contain 2 dark blue bags.\n" +
            "dark blue bags contain 2 dark violet bags.\n" +
            "dark violet bags contain no other bags.";

    @BeforeEach
    void setup() {
        testService = new AdventServiceSeven(webRepository);
    }

    @Test
    void adventOne_goodData_result() {
        when(webRepository.getData(7)).thenReturn(TEST_BAGS);
        assertEquals(4, testService.getAdvent1Result());
    }

    @Test
    void adventTwo_goodData_result() {
        when(webRepository.getData(7)).thenReturn(TEST_BAGS);
        assertEquals(32, testService.getAdvent2Result());
    }

    @Test
    void adventTwo_goodData2_result() {
        when(webRepository.getData(7)).thenReturn(TEST_BAGS_2);
        assertEquals(126, testService.getAdvent2Result());
    }
}
