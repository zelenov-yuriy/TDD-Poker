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
}