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
        Card[] cards =
                {deck.getCard(0), deck.getCard(1), deck.getCard(2), deck.getCard(3), deck.getCard(4)};
        Combination combination = new Combination(cards);
        boolean exceptionThrown = false;
        try {
            combination.sortCards();
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);
        System.out.print(combination);
        System.out.println("sortCardsTest - passed");
    }

    @Test
    public void combIdentTest() {
        Deck deck = new Deck();
        Card[] highestCard =
                {deck.getCard(26), deck.getCard(17), deck.getCard(0), deck.getCard(50), deck.getCard(34)};
        Card[] pair =
                {deck.getCard(34), deck.getCard(50), deck.getCard(26), deck.getCard(0), deck.getCard(1)};
        Card[] twoPairs =
                {deck.getCard(0), deck.getCard(5), deck.getCard(1), deck.getCard(39), deck.getCard(7)};
        Card[] three =
                {deck.getCard(1), deck.getCard(0), deck.getCard(39), deck.getCard(7), deck.getCard(2)};
        Card[] straight1 =
                {deck.getCard(31), deck.getCard(33), deck.getCard(21), deck.getCard(24), deck.getCard(38)};
        Card[] straight2 =
                {deck.getCard(5), deck.getCard(1), deck.getCard(49), deck.getCard(9), deck.getCard(14)};
        Card[] flush =
                {deck.getCard(17), deck.getCard(9), deck.getCard(37), deck.getCard(29), deck.getCard(1)};
        Card[] fullHouse =
                {deck.getCard(44), deck.getCard(45), deck.getCard(0), deck.getCard(47), deck.getCard(3)};
        Card[] four =
                {deck.getCard(16), deck.getCard(19), deck.getCard(42), deck.getCard(18), deck.getCard(17)};
        Card[] straightFlush =
                {deck.getCard(33), deck.getCard(41), deck.getCard(37), deck.getCard(45), deck.getCard(29)};

        Combination highestCardComb = new Combination(highestCard);
        Combination pairComb = new Combination(pair);
        Combination twoPairsComb = new Combination(twoPairs);
        Combination threeComb = new Combination(three);
        Combination straight1Comb = new Combination(straight1);
        Combination straight2Comb = new Combination(straight2);
        Combination flushComb = new Combination(flush);
        Combination fullHouseComb = new Combination(fullHouse);
        Combination fourComb = new Combination(four);
        Combination straightFlushComb = new Combination(straightFlush);

        System.out.println(highestCardComb);
        System.out.println(pairComb);
        System.out.println(twoPairsComb);
        System.out.println(threeComb);
        System.out.println(straight1Comb);
        System.out.println(straight2Comb);
        System.out.println(flushComb);
        System.out.println(fullHouseComb);
        System.out.println(fourComb);
        System.out.println(straightFlushComb);
    }
}