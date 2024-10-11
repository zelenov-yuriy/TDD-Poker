package tdd.poker.combinations;

import tdd.poker.cards.prepare.Set;

public class StraightFlush extends Combination {
    public StraightFlush(Set set) {
        super(set);
    }

    @Override
    public int compare(Combination comb) {
        int rank1;
        int rank2;

        rank1 = getStraightFlushRank(this.set);
        rank2 = getStraightFlushRank(comb.set);

        if (rank1 > rank2)
            return 1;
        if (rank1 < rank2)
            return -1;
        return 0;
    }

    private int getStraightFlushRank(Set set) {
        int rank = 0;

        if (set.getCard(0).getDeckNumber() / 4 == 0 &&
                set.getCard(4).getDeckNumber() / 4 == 12) rank = -1;
        else
            rank = set.getCard(0).getDeckNumber() / 4;

        return rank;
    }

    @Override
    public String toString() {
        return  "Straight Flush:" + '\n'
                + set.getCard(0).toString() + '\n'
                + set.getCard(1).toString() + '\n'
                + set.getCard(2).toString() + '\n'
                + set.getCard(3).toString() + '\n'
                + set.getCard(4).toString() + '\n';
    }
}
