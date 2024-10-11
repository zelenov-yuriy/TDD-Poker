package tdd.poker.combinations;

import tdd.poker.cards.prepare.Set;

public abstract class Combination {
    Set set;
    private final int combPriority;

    /*
     * combPriority - card combination
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

    public Combination(Set set) {
        this.set = set;
        combPriority = set.recognize();
    }

    public int getCombPriority() {
        return combPriority;
    }

    public abstract int compare(Combination comb);
}
