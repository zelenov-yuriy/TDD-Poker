package tdd.poker;

public class Combination {
    private final Card[] cards;
    private final int priority;
    private final String strType;

    /*
     * priority - strType
     * -----------------
     * 0 - Highest Card
     * 1 - Pair
     * 2 - Two Pairs
     * 3 - Three
     * 4 - Straight
     * 5 - Flush
     * 6 - Full House
     * 7 - Four
     * 8 - Straight Flush
     */

    public Combination(Card[] cards) {
        this.cards = cards;
        sortCards();
        priority = 0;
        strType = "strType";
    }
    public int getPriority() {
        return priority;
    }

    public Card getCard(int n) {
        return cards[n];
    }

    @Override
    public String toString() {
        return strType + '\n'
                + cards[0].toString() + '\n'
                + cards[1].toString() + '\n'
                + cards[2].toString() + '\n'
                + cards[3].toString() + '\n'
                + cards[4].toString() + '\n';
    }

    public void sortCards() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < (4 - i); j++) {
                if (cards[j].getDeckNumber() > cards[j + 1].getDeckNumber()) {
                    Card temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
    }
}
