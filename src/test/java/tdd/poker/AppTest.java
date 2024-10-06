package tdd.poker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown \n");
    }

    @Test
    public void cardCreationTest() {
        Card card = new Card(0, "2", "clubs");
        String result = card.toString();
        assertEquals("0) 2 of clubs", result);
        System.out.println("cardCreationTest - passed");
    }

    @Test
    public void deckShuffleTest() {
        Deck deck = new Deck();
        boolean exceptionThrown = false;
        try {
                deck.shuffle();
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
        System.out.println("deckShuffleTest - passed");
    }

    @Test
    public void sortCardsTest() {
        Deck deck = new Deck();
        deck.shuffle();
        Set set = new Set(deck.getCard(0), deck.getCard(1), deck.getCard(2), deck.getCard(3), deck.getCard(4));
        boolean exceptionThrown = false;
        try {
            set.sortCards();
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
        System.out.print(set);
        System.out.println("sortCardsTest - passed");
    }

    @Test
    public void setRecognizeTest() {
        Deck deck = new Deck();

        Set highestCardSet = new Set(deck.getCard(26), deck.getCard(17), deck.getCard(0), deck.getCard(50), deck.getCard(34));
        Set pairSet = new Set(deck.getCard(34), deck.getCard(50), deck.getCard(26), deck.getCard(0), deck.getCard(1));
        Set twoPairsSet = new Set(deck.getCard(0), deck.getCard(5), deck.getCard(1), deck.getCard(39), deck.getCard(7));
        Set threeSet = new Set(deck.getCard(1), deck.getCard(0), deck.getCard(39), deck.getCard(7), deck.getCard(2));
        Set straight1Set = new Set(deck.getCard(31), deck.getCard(33), deck.getCard(21), deck.getCard(24), deck.getCard(38));
        Set straight2Set = new Set(deck.getCard(5), deck.getCard(1), deck.getCard(49), deck.getCard(9), deck.getCard(14));
        Set flushSet = new Set(deck.getCard(17), deck.getCard(9), deck.getCard(37), deck.getCard(29), deck.getCard(1));
        Set fullHouseSet = new Set(deck.getCard(44), deck.getCard(45), deck.getCard(0), deck.getCard(47), deck.getCard(3));
        Set fourSet = new Set(deck.getCard(16), deck.getCard(19), deck.getCard(42), deck.getCard(18), deck.getCard(17));
        Set straightFlushSet = new Set(deck.getCard(33), deck.getCard(41), deck.getCard(37), deck.getCard(45), deck.getCard(29));

        assertEquals(0, highestCardSet.recognize());
        assertEquals(1, pairSet.recognize());
        assertEquals(2, twoPairsSet.recognize());
        assertEquals(3, threeSet.recognize());
        assertEquals(4, straight1Set.recognize());
        assertEquals(4, straight2Set.recognize());
        assertEquals(5, flushSet.recognize());
        assertEquals(6, fullHouseSet.recognize());
        assertEquals(7, fourSet.recognize());
        assertEquals(8, straightFlushSet.recognize());
    }
}