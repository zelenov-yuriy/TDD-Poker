package tdd.poker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DealTest {
    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown \n");
    }

    @Test
    void dealTest() {
        Deal deal = new Deal();
        deal.setCombs();
        deal.showCombs();
        deal.setWinners();
        deal.showWinners();
    }
}
