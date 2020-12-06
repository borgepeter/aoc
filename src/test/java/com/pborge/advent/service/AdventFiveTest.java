package com.pborge.advent.service;

import com.pborge.advent.models.Seat;
import com.pborge.advent.repository.WebRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdventFiveTest {
    @Mock
    WebRepository webRepository;

    AdventServiceFive testService;

    private final String SEAT_1 = "BFFFBBFRRR";
    private final String SEAT_2 = "FFFBBBFRRR";
    private final String SEAT_3 = "BBFFBBFRLL";

    @BeforeEach
    void setup() {
        testService = new AdventServiceFive(webRepository);
    }

    @Test
    void getSeat_goodData1_seatReturned() {
        Seat testSeat = testService.getSeat(SEAT_1);
        assertEquals(70, testSeat.getRow());
        assertEquals(7, testSeat.getColumn());
        assertEquals(567, testSeat.getId());
    }

    @Test
    void getSeat_goodData2_seatReturned() {
        Seat testSeat = testService.getSeat(SEAT_2);
        assertEquals(14, testSeat.getRow());
        assertEquals(7, testSeat.getColumn());
        assertEquals(119, testSeat.getId());
    }

    @Test
    void getSeat_goodData3_seatReturned() {
        Seat testSeat = testService.getSeat(SEAT_3);
        assertEquals(102, testSeat.getRow());
        assertEquals(4, testSeat.getColumn());
        assertEquals(820, testSeat.getId());
    }
}
