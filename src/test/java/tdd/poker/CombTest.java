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

        assertEquals(1, pairComb9.compare(pairComb10));
    }

    @Test
    public void twoPairsCompare() {
        Deck deck = new Deck();

        Set twoPairsSet1 = new Set(deck.getCard(41), deck.getCard(33), deck.getCard(34), deck.getCard(49), deck.getCard(40));
        Set twoPairsSet2 = new Set(deck.getCard(38), deck.getCard(11), deck.getCard(10), deck.getCard(50), deck.getCard(48));

        assertEquals(2, twoPairsSet1.recognize());
        assertEquals(2, twoPairsSet2.recognize());

        Combination twoPairsComb1 = new TwoPairs(twoPairsSet1);
        Combination twoPairsComb2 = new TwoPairs(twoPairsSet2);

        assertEquals(-1, twoPairsComb1.compare(twoPairsComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet3 = new Set(deck.getCard(31), deck.getCard(51), deck.getCard(38), deck.getCard(36), deck.getCard(29));
        Set twoPairsSet4 = new Set(deck.getCard(32), deck.getCard(39), deck.getCard(37), deck.getCard(35), deck.getCard(44));

        assertEquals(2, twoPairsSet3.recognize());
        assertEquals(2, twoPairsSet4.recognize());

        Combination twoPairsComb3 = new TwoPairs(twoPairsSet3);
        Combination twoPairsComb4 = new TwoPairs(twoPairsSet4);

        assertEquals(-1, twoPairsComb3.compare(twoPairsComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet5 = new Set(deck.getCard(40), deck.getCard(41), deck.getCard(28), deck.getCard(30), deck.getCard(6));
        Set twoPairsSet6 = new Set(deck.getCard(43), deck.getCard(42), deck.getCard(29), deck.getCard(31), deck.getCard(10));

        assertEquals(2, twoPairsSet5.recognize());
        assertEquals(2, twoPairsSet6.recognize());

        Combination twoPairsComb5 = new TwoPairs(twoPairsSet5);
        Combination twoPairsComb6 = new TwoPairs(twoPairsSet6);

        assertEquals(-1, twoPairsComb5.compare(twoPairsComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet7 = new Set(deck.getCard(30), deck.getCard(12), deck.getCard(46), deck.getCard(44), deck.getCard(28));
        Set twoPairsSet8 = new Set(deck.getCard(15), deck.getCard(47), deck.getCard(29), deck.getCard(31), deck.getCard(45));

        assertEquals(2, twoPairsSet7.recognize());
        assertEquals(2, twoPairsSet8.recognize());

        Combination twoPairsComb7 = new TwoPairs(twoPairsSet7);
        Combination twoPairsComb8 = new TwoPairs(twoPairsSet8);;

        assertEquals(0, twoPairsComb7.compare(twoPairsComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet9 = new Set(deck.getCard(28), deck.getCard(46), deck.getCard(30), deck.getCard(44), deck.getCard(12));
        Set twoPairsSet10 = new Set(deck.getCard(29), deck.getCard(42), deck.getCard(40), deck.getCard(31), deck.getCard(15));

        assertEquals(2, twoPairsSet9.recognize());
        assertEquals(2, twoPairsSet10.recognize());

        Combination twoPairsComb9 = new TwoPairs(twoPairsSet9);
        Combination twoPairsComb10 = new TwoPairs(twoPairsSet10);

        assertEquals(1, twoPairsComb9.compare(twoPairsComb10));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet11 = new Set(deck.getCard(33), deck.getCard(46), deck.getCard(35), deck.getCard(44), deck.getCard(12));
        Set twoPairsSet12 = new Set(deck.getCard(29), deck.getCard(47), deck.getCard(45), deck.getCard(31), deck.getCard(15));

        assertEquals(2, twoPairsSet11.recognize());
        assertEquals(2, twoPairsSet12.recognize());

        Combination twoPairsComb11 = new TwoPairs(twoPairsSet11);
        Combination twoPairsComb12 = new TwoPairs(twoPairsSet12);

        assertEquals(1, twoPairsComb11.compare(twoPairsComb12));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set twoPairsSet13 = new Set(deck.getCard(33), deck.getCard(46), deck.getCard(35), deck.getCard(44), deck.getCard(21));
        Set twoPairsSet14 = new Set(deck.getCard(32), deck.getCard(47), deck.getCard(45), deck.getCard(34), deck.getCard(15));

        assertEquals(2, twoPairsSet13.recognize());
        assertEquals(2, twoPairsSet14.recognize());

        Combination twoPairsComb13 = new TwoPairs(twoPairsSet13);
        Combination twoPairsComb14 = new TwoPairs(twoPairsSet14);

        assertEquals(1, twoPairsComb13.compare(twoPairsComb14));
    }

    @Test
    public void threeCompare() {
        Deck deck = new Deck();

        Set threeSet1 = new Set(deck.getCard(40), deck.getCard(14), deck.getCard(15), deck.getCard(49), deck.getCard(13));
        Set threeSet2 = new Set(deck.getCard(29), deck.getCard(27), deck.getCard(36), deck.getCard(38), deck.getCard(37));

        assertEquals(3, threeSet1.recognize());
        assertEquals(3, threeSet2.recognize());

        Combination threeComb1 = new Three(threeSet1);
        Combination threeComb2 = new Three(threeSet2);

        assertEquals(-1, threeComb1.compare(threeComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet3 = new Set(deck.getCard(39), deck.getCard(29), deck.getCard(36), deck.getCard(27), deck.getCard(38));
        Set threeSet4 = new Set(deck.getCard(37), deck.getCard(32), deck.getCard(36), deck.getCard(38), deck.getCard(27));

        assertEquals(3, threeSet3.recognize());
        assertEquals(3, threeSet4.recognize());

        Combination threeComb3 = new Three(threeSet3);
        Combination threeComb4 = new Three(threeSet4);

        assertEquals(-1, threeComb3.compare(threeComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet5 = new Set(deck.getCard(23), deck.getCard(38), deck.getCard(39), deck.getCard(36), deck.getCard(32));
        Set threeSet6 = new Set(deck.getCard(37), deck.getCard(38), deck.getCard(36), deck.getCard(32), deck.getCard(27));

        assertEquals(3, threeSet5.recognize());
        assertEquals(3, threeSet6.recognize());

        Combination threeComb5 = new Three(threeSet5);
        Combination threeComb6 = new Three(threeSet6);

        assertEquals(-1, threeComb5.compare(threeComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet7 = new Set(deck.getCard(27), deck.getCard(38), deck.getCard(39), deck.getCard(36), deck.getCard(32));
        Set threeSet8 = new Set(deck.getCard(37), deck.getCard(38), deck.getCard(36), deck.getCard(32), deck.getCard(27));

        assertEquals(3, threeSet7.recognize());
        assertEquals(3, threeSet8.recognize());

        Combination threeComb7 = new Three(threeSet7);
        Combination threeComb8 = new Three(threeSet8);

        assertEquals(0, threeComb7.compare(threeComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet9 = new Set(deck.getCard(27), deck.getCard(42), deck.getCard(43), deck.getCard(40), deck.getCard(32));
        Set threeSet10 = new Set(deck.getCard(37), deck.getCard(38), deck.getCard(36), deck.getCard(32), deck.getCard(27));

        assertEquals(3, threeSet9.recognize());
        assertEquals(3, threeSet10.recognize());

        Combination threeComb9 = new Three(threeSet9);
        Combination threeComb10 = new Three(threeSet10);

        assertEquals(1, threeComb9.compare(threeComb10));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet11 = new Set(deck.getCard(27), deck.getCard(43), deck.getCard(42), deck.getCard(40), deck.getCard(37));
        Set threeSet12 = new Set(deck.getCard(40), deck.getCard(32), deck.getCard(42), deck.getCard(43), deck.getCard(27));

        assertEquals(3, threeSet11.recognize());
        assertEquals(3, threeSet12.recognize());

        Combination threeComb11 = new Three(threeSet11);
        Combination threeComb12 = new Three(threeSet12);

        assertEquals(1, threeComb11.compare(threeComb12));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set threeSet13 = new Set(deck.getCard(32), deck.getCard(43), deck.getCard(42), deck.getCard(40), deck.getCard(37));
        Set threeSet14 = new Set(deck.getCard(41), deck.getCard(27), deck.getCard(42), deck.getCard(43), deck.getCard(39));

        assertEquals(3, threeSet13.recognize());
        assertEquals(3, threeSet14.recognize());

        Combination threeComb13 = new Three(threeSet13);
        Combination threeComb14 = new Three(threeSet14);

        assertEquals(1, threeComb13.compare(threeComb14));
    }

    @Test
    public void straightCompare() {
        Deck deck = new Deck();

        Set straightSet1 = new Set(deck.getCard(17), deck.getCard(20), deck.getCard(8), deck.getCard(13), deck.getCard(27));
        Set straightSet2 = new Set(deck.getCard(33), deck.getCard(25), deck.getCard(36), deck.getCard(22), deck.getCard(30));

        assertEquals(4, straightSet1.recognize());
        assertEquals(4, straightSet2.recognize());

        Combination straightComb1 = new Straight(straightSet1);
        Combination straightComb2 = new Straight(straightSet2);

        assertEquals(-1, straightComb1.compare(straightComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightSet3 = new Set(deck.getCard(9), deck.getCard(51), deck.getCard(1), deck.getCard(13), deck.getCard(6));
        Set straightSet4 = new Set(deck.getCard(25), deck.getCard(36), deck.getCard(30), deck.getCard(33), deck.getCard(22));

        assertEquals(4, straightSet3.recognize());
        assertEquals(4, straightSet4.recognize());

        Combination straightComb3 = new Straight(straightSet3);
        Combination straightComb4 = new Straight(straightSet4);

        assertEquals(-1, straightComb3.compare(straightComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightSet5 = new Set(deck.getCard(37), deck.getCard(30), deck.getCard(25), deck.getCard(34), deck.getCard(22));
        Set straightSet6 = new Set(deck.getCard(22), deck.getCard(36), deck.getCard(33), deck.getCard(30), deck.getCard(25));

        assertEquals(4, straightSet5.recognize());
        assertEquals(4, straightSet6.recognize());

        Combination straightComb5 = new Straight(straightSet5);
        Combination straightComb6 = new Straight(straightSet6);

        assertEquals(0, straightComb5.compare(straightComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightSet7 = new Set(deck.getCard(30), deck.getCard(25), deck.getCard(36), deck.getCard(33), deck.getCard(40));
        Set straightSet8 = new Set(deck.getCard(33), deck.getCard(30), deck.getCard(22), deck.getCard(36), deck.getCard(25));

        assertEquals(4, straightSet7.recognize());
        assertEquals(4, straightSet8.recognize());

        Combination straightComb7 = new Straight(straightSet7);
        Combination straightComb8 = new Straight(straightSet8);

        assertEquals(1, straightComb7.compare(straightComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightSet9 = new Set(deck.getCard(10), deck.getCard(5), deck.getCard(13), deck.getCard(0), deck.getCard(16));
        Set straightSet10 = new Set(deck.getCard(13), deck.getCard(50), deck.getCard(0), deck.getCard(10), deck.getCard(5));

        assertEquals(4, straightSet9.recognize());
        assertEquals(4, straightSet10.recognize());

        Combination straightComb9 = new Straight(straightSet9);
        Combination straightComb10 = new Straight(straightSet10);

        assertEquals(1, straightComb9.compare(straightComb10));
    }

    @Test
    public void flushCompare() {
        Deck deck = new Deck();

        Set flushSet1 = new Set(deck.getCard(12), deck.getCard(0), deck.getCard(28), deck.getCard(16), deck.getCard(20));
        Set flushSet2 = new Set(deck.getCard(35), deck.getCard(3), deck.getCard(47), deck.getCard(31), deck.getCard(39));

        assertEquals(5, flushSet1.recognize());
        assertEquals(5, flushSet2.recognize());

        Combination flushComb1 = new Flush(flushSet1);
        Combination flushComb2 = new Flush(flushSet2);

        assertEquals(-1, flushComb1.compare(flushComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set flushSet3 = new Set(deck.getCard(12), deck.getCard(0), deck.getCard(28), deck.getCard(16), deck.getCard(20));
        Set flushSet4 = new Set(deck.getCard(14), deck.getCard(2), deck.getCard(18), deck.getCard(30), deck.getCard(22));

        assertEquals(5, flushSet3.recognize());
        assertEquals(5, flushSet4.recognize());

        Combination flushComb3 = new Flush(flushSet3);
        Combination flushComb4 = new Flush(flushSet4);

        assertEquals(0, flushComb3.compare(flushComb4));
    }

    @Test
    public void fullHouseCompare() {
        Deck deck = new Deck();

        Set fullHouseSet1 = new Set(deck.getCard(11), deck.getCard(5), deck.getCard(9), deck.getCard(8), deck.getCard(6));
        Set fullHouseSet2 = new Set(deck.getCard(6), deck.getCard(22), deck.getCard(21), deck.getCard(5), deck.getCard(23));

        assertEquals(6, fullHouseSet1.recognize());
        assertEquals(6, fullHouseSet2.recognize());

        Combination fullHouseComb1 = new FullHouse(fullHouseSet1);
        Combination fullHouseComb2 = new FullHouse(fullHouseSet2);

        assertEquals(-1, fullHouseComb1.compare(fullHouseComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fullHouseSet3 = new Set(deck.getCard(21), deck.getCard(1), deck.getCard(22), deck.getCard(23), deck.getCard(2));
        Set fullHouseSet4 = new Set(deck.getCard(6), deck.getCard(22), deck.getCard(21), deck.getCard(5), deck.getCard(23));

        assertEquals(6, fullHouseSet3.recognize());
        assertEquals(6, fullHouseSet4.recognize());

        Combination fullHouseComb3 = new FullHouse(fullHouseSet3);
        Combination fullHouseComb4 = new FullHouse(fullHouseSet4);

        assertEquals(-1, fullHouseComb3.compare(fullHouseComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fullHouseSet5 = new Set(deck.getCard(21), deck.getCard(4), deck.getCard(22), deck.getCard(23), deck.getCard(7));
        Set fullHouseSet6 = new Set(deck.getCard(6), deck.getCard(22), deck.getCard(21), deck.getCard(5), deck.getCard(23));

        assertEquals(6, fullHouseSet5.recognize());
        assertEquals(6, fullHouseSet6.recognize());

        Combination fullHouseComb5 = new FullHouse(fullHouseSet5);
        Combination fullHouseComb6 = new FullHouse(fullHouseSet6);

        assertEquals(0, fullHouseComb5.compare(fullHouseComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fullHouseSet7 = new Set(deck.getCard(33), deck.getCard(1), deck.getCard(34), deck.getCard(35), deck.getCard(2));
        Set fullHouseSet8 = new Set(deck.getCard(6), deck.getCard(22), deck.getCard(21), deck.getCard(5), deck.getCard(23));

        assertEquals(6, fullHouseSet7.recognize());
        assertEquals(6, fullHouseSet8.recognize());

        Combination fullHouseComb7 = new FullHouse(fullHouseSet7);
        Combination fullHouseComb8 = new FullHouse(fullHouseSet8);

        assertEquals(1, fullHouseComb7.compare(fullHouseComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fullHouseSet9 = new Set(deck.getCard(21), deck.getCard(44), deck.getCard(22), deck.getCard(23), deck.getCard(46));
        Set fullHouseSet10 = new Set(deck.getCard(6), deck.getCard(22), deck.getCard(21), deck.getCard(5), deck.getCard(23));

        assertEquals(6, fullHouseSet9.recognize());
        assertEquals(6, fullHouseSet10.recognize());

        Combination fullHouseComb9 = new FullHouse(fullHouseSet9);
        Combination fullHouseComb10 = new FullHouse(fullHouseSet10);

        assertEquals(1, fullHouseComb9.compare(fullHouseComb10));
    }

    @Test
    public void fourCompare() {
        Deck deck = new Deck();

        Set fourSet1 = new Set(deck.getCard(21), deck.getCard(20), deck.getCard(0), deck.getCard(23), deck.getCard(22));
        Set fourSet2 = new Set(deck.getCard(24), deck.getCard(1), deck.getCard(27), deck.getCard(26), deck.getCard(25));

        assertEquals(7, fourSet1.recognize());
        assertEquals(7, fourSet2.recognize());

        Combination fourComb1 = new Four(fourSet1);
        Combination fourComb2 = new Four(fourSet2);

        assertEquals(-1, fourComb1.compare(fourComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fourSet3 = new Set(deck.getCard(26), deck.getCard(25), deck.getCard(0), deck.getCard(24), deck.getCard(27));
        Set fourSet4 = new Set(deck.getCard(24), deck.getCard(5), deck.getCard(27), deck.getCard(26), deck.getCard(25));

        assertEquals(7, fourSet3.recognize());
        assertEquals(7, fourSet4.recognize());

        Combination fourComb3 = new Four(fourSet3);
        Combination fourComb4 = new Four(fourSet4);

        assertEquals(-1, fourComb3.compare(fourComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fourSet5 = new Set(deck.getCard(25), deck.getCard(24), deck.getCard(4), deck.getCard(26), deck.getCard(27));
        Set fourSet6 = new Set(deck.getCard(24), deck.getCard(5), deck.getCard(27), deck.getCard(26), deck.getCard(25));

        assertEquals(7, fourSet5.recognize());
        assertEquals(7, fourSet6.recognize());

        Combination fourComb5 = new Four(fourSet5);
        Combination fourComb6 = new Four(fourSet6);

        assertEquals(0, fourComb5.compare(fourComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fourSet7 = new Set(deck.getCard(47), deck.getCard(45), deck.getCard(0), deck.getCard(46), deck.getCard(44));
        Set fourSet8 = new Set(deck.getCard(25), deck.getCard(5), deck.getCard(27), deck.getCard(26), deck.getCard(24));

        assertEquals(7, fourSet7.recognize());
        assertEquals(7, fourSet8.recognize());

        Combination fourComb7 = new Four(fourSet7);
        Combination fourComb8 = new Four(fourSet8);

        assertEquals(1, fourComb7.compare(fourComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set fourSet9 = new Set(deck.getCard(24), deck.getCard(25), deck.getCard(48), deck.getCard(26), deck.getCard(27));
        Set fourSet10 = new Set(deck.getCard(24), deck.getCard(5), deck.getCard(27), deck.getCard(26), deck.getCard(25));

        assertEquals(7, fourSet9.recognize());
        assertEquals(7, fourSet10.recognize());

        Combination fourComb9 = new Four(fourSet9);
        Combination fourComb10 = new Four(fourSet10);

        assertEquals(1, fourComb9.compare(fourComb10));
    }

    @Test
    public void straightFlushCompare() {
        Deck deck = new Deck();

        Set straightFlushSet1 = new Set(deck.getCard(17), deck.getCard(21), deck.getCard(9), deck.getCard(13), deck.getCard(25));
        Set straightFlushSet2 = new Set(deck.getCard(33), deck.getCard(25), deck.getCard(37), deck.getCard(21), deck.getCard(29));

        assertEquals(8, straightFlushSet1.recognize());
        assertEquals(8, straightFlushSet2.recognize());

        Combination straightFlushComb1 = new StraightFlush(straightFlushSet1);
        Combination straightFlushComb2 = new StraightFlush(straightFlushSet2);

        assertEquals(-1, straightFlushComb1.compare(straightFlushComb2));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightFlushSet3 = new Set(deck.getCard(11), deck.getCard(51), deck.getCard(3), deck.getCard(15), deck.getCard(7));
        Set straightFlushSet4 = new Set(deck.getCard(25), deck.getCard(37), deck.getCard(29), deck.getCard(33), deck.getCard(21));

        assertEquals(8, straightFlushSet3.recognize());
        assertEquals(8, straightFlushSet4.recognize());

        Combination straightFlushComb3 = new StraightFlush(straightFlushSet3);
        Combination straightFlushComb4 = new StraightFlush(straightFlushSet4);

        assertEquals(-1, straightFlushComb3.compare(straightFlushComb4));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightFlushSet5 = new Set(deck.getCard(37), deck.getCard(29), deck.getCard(25), deck.getCard(33), deck.getCard(21));
        Set straightFlushSet6 = new Set(deck.getCard(22), deck.getCard(30), deck.getCard(34), deck.getCard(38), deck.getCard(26));

        assertEquals(8, straightFlushSet5.recognize());
        assertEquals(8, straightFlushSet6.recognize());

        Combination straightFlushComb5 = new Straight(straightFlushSet5);
        Combination straightFlushComb6 = new Straight(straightFlushSet6);

        assertEquals(0, straightFlushComb5.compare(straightFlushComb6));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightFlushSet7 = new Set(deck.getCard(30), deck.getCard(26), deck.getCard(38), deck.getCard(34), deck.getCard(42));
        Set straightFlushSet8 = new Set(deck.getCard(33), deck.getCard(29), deck.getCard(21), deck.getCard(37), deck.getCard(25));

        assertEquals(8, straightFlushSet7.recognize());
        assertEquals(8, straightFlushSet8.recognize());

        Combination straightFlushComb7 = new Straight(straightFlushSet7);
        Combination straightFlushComb8 = new Straight(straightFlushSet8);

        assertEquals(1, straightFlushComb7.compare(straightFlushComb8));

        //---------------------------------------------------------------------------------------------------------------------------------

        Set straightFlushSet9 = new Set(deck.getCard(10), deck.getCard(6), deck.getCard(14), deck.getCard(2), deck.getCard(18));
        Set straightFlushSet10 = new Set(deck.getCard(13), deck.getCard(49), deck.getCard(1), deck.getCard(9), deck.getCard(5));

        assertEquals(8, straightFlushSet9.recognize());
        assertEquals(8, straightFlushSet10.recognize());

        Combination straightFlushComb9 = new Straight(straightFlushSet9);
        Combination straightFlushComb10 = new Straight(straightFlushSet10);

        assertEquals(1, straightFlushComb9.compare(straightFlushComb10));
    }
}
