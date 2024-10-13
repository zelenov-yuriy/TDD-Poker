package tdd.poker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DealTest {
    @BeforeEach
    void setUp() {
        System.out.println("setUp\n");
    }

    @AfterEach
    void tearDown() {
        System.out.println("\ntearDown");
    }

    @Test
    void dealTwoPlayersTest() {
        Deal deal = new Deal(2);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealThreePlayersTest() {
        Deal deal = new Deal(3);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealFourPlayersTest() {
        Deal deal = new Deal(4);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealFivePlayersTest() {
        Deal deal = new Deal(5);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealSixPlayersTest() {
        Deal deal = new Deal(6);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealSevenPlayersTest() {
        Deal deal = new Deal(7);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealEightPlayersTest() {
        Deal deal = new Deal(8);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealNinePlayersTest() {
        Deal deal = new Deal(9);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }

    @Test
    void dealTenPlayersTest() {
        Deal deal = new Deal(10);
        deal.setPlayersCombs();
        deal.showPlayersCombs();
        deal.setWinners();
        deal.showWinners();
    }
}
