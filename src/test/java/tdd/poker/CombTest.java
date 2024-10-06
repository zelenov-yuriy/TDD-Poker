package tdd.poker;

import tdd.poker.combinations.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CombTest {

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown \n");
    }

    @Test
    public void highestCardCompareTest() {
        Deck deck = new Deck();

        Set highestCardSet1 = new Set(deck.getCard(6), deck.getCard(20), deck.getCard(39), deck.getCard(25), deck.getCard(13));
        Set highestCardSet2 = new Set(deck.getCard(45), deck.getCard(38), deck.getCard(21), deck.getCard(1), deck.getCard(11));

        assertEquals(0, highestCardSet1.recognize());
        assertEquals(0, highestCardSet2.recognize());

        Combination highestCardComb1 = new HighestCard(highestCardSet1);
        Combination highestCardComb2 = new HighestCard(highestCardSet2);

        assertEquals(-1, highestCardComb1.compare(highestCardComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set highestCardSet3 = new Set(deck.getCard(41), deck.getCard(51), deck.getCard(0), deck.getCard(22), deck.getCard(32));
        Set highestCardSet4 = new Set(deck.getCard(34), deck.getCard(1), deck.getCard(48), deck.getCard(28), deck.getCard(43));

        assertEquals(0, highestCardSet1.recognize());
        assertEquals(0, highestCardSet2.recognize());

        Combination highestCardComb3 = new HighestCard(highestCardSet3);
        Combination highestCardComb4 = new HighestCard(highestCardSet4);

        assertEquals(-1, highestCardComb3.compare(highestCardComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set highestCardSet5 = new Set(deck.getCard(29), deck.getCard(42), deck.getCard(8), deck.getCard(47), deck.getCard(21));
        Set highestCardSet6 = new Set(deck.getCard(10), deck.getCard(23), deck.getCard(28), deck.getCard(43), deck.getCard(45));

        assertEquals(0, highestCardSet5.recognize());
        assertEquals(0, highestCardSet6.recognize());

        Combination highestCardComb5 = new HighestCard(highestCardSet5);
        Combination highestCardComb6 = new HighestCard(highestCardSet6);

        assertEquals(0, highestCardComb5.compare(highestCardComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set highestCardSet7 = new Set(deck.getCard(32), deck.getCard(26), deck.getCard(17), deck.getCard(9), deck.getCard(0));
        Set highestCardSet8 = new Set(deck.getCard(27), deck.getCard(29), deck.getCard(1), deck.getCard(10), deck.getCard(16));

        assertEquals(0, highestCardSet7.recognize());
        assertEquals(0, highestCardSet8.recognize());

        Combination highestCardComb7 = new HighestCard(highestCardSet7);
        Combination highestCardComb8 = new HighestCard(highestCardSet8);

        assertEquals(1, highestCardComb7.compare(highestCardComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set highestCardSet9 = new Set(deck.getCard(42), deck.getCard(48), deck.getCard(16), deck.getCard(37), deck.getCard(24));
        Set highestCardSet10 = new Set(deck.getCard(3), deck.getCard(41), deck.getCard(49), deck.getCard(25), deck.getCard(39));

        assertEquals(0, highestCardSet9.recognize());
        assertEquals(0, highestCardSet10.recognize());

        Combination highestCardComb9 = new HighestCard(highestCardSet9);
        Combination highestCardComb10 = new HighestCard(highestCardSet10);

        assertEquals(1, highestCardComb9.compare(highestCardComb10));
    }

    @Test
    public void pairCompareTest() {
        Deck deck = new Deck();

        Set pairSet1 = new Set(deck.getCard(25), deck.getCard(14), deck.getCard(39), deck.getCard(12), deck.getCard(33));
        Set pairSet2 = new Set(deck.getCard(34), deck.getCard(1), deck.getCard(21), deck.getCard(35), deck.getCard(11));

        assertEquals(1, pairSet1.recognize());
        assertEquals(1, pairSet2.recognize());

        Combination pairComb1 = new Pair(pairSet1);
        Combination pairComb2 = new Pair(pairSet2);

        assertEquals(-1, pairComb1.compare(pairComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set pairSet3 = new Set(deck.getCard(25), deck.getCard(14), deck.getCard(39), deck.getCard(12), deck.getCard(33));
        Set pairSet4 = new Set(deck.getCard(13), deck.getCard(15), deck.getCard(38), deck.getCard(35), deck.getCard(29));

        assertEquals(1, pairSet3.recognize());
        assertEquals(1, pairSet4.recognize());

        Combination pairComb3 = new Pair(pairSet3);
        Combination pairComb4 = new Pair(pairSet4);

        assertEquals(-1, pairComb3.compare(pairComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set pairSet5 = new Set(deck.getCard(25), deck.getCard(40), deck.getCard(39), deck.getCard(43), deck.getCard(33));
        Set pairSet6 = new Set(deck.getCard(26), deck.getCard(38), deck.getCard(35), deck.getCard(41), deck.getCard(42));

        assertEquals(1, pairSet5.recognize());
        assertEquals(1, pairSet6.recognize());

        Combination pairComb5 = new Pair(pairSet5);
        Combination pairComb6 = new Pair(pairSet6);

        assertEquals(0, pairComb5.compare(pairComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set pairSet7 = new Set(deck.getCard(44), deck.getCard(46), deck.getCard(25), deck.getCard(19), deck.getCard(33));
        Set pairSet8 = new Set(deck.getCard(42), deck.getCard(43), deck.getCard(36), deck.getCard(35), deck.getCard(2));

        assertEquals(1, pairSet7.recognize());
        assertEquals(1, pairSet8.recognize());

        Combination pairComb7 = new Pair(pairSet7);
        Combination pairComb8 = new Pair(pairSet8);

        assertEquals(1, pairComb7.compare(pairComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set pairSet9 = new Set(deck.getCard(0), deck.getCard(39), deck.getCard(43), deck.getCard(2), deck.getCard(33));
        Set pairSet10 = new Set(deck.getCard(35), deck.getCard(41), deck.getCard(3), deck.getCard(1), deck.getCard(12));

        assertEquals(1, pairSet9.recognize());
        assertEquals(1, pairSet10.recognize());

        Combination pairComb9 = new Pair(pairSet9);
        Combination pairComb10 = new Pair(pairSet10);

        System.out.println(pairComb9);
        System.out.println(pairComb10);

        assertEquals(1, pairComb9.compare(pairComb10));
    }
}
