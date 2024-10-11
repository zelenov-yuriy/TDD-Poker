package tdd.poker.combinations;

import tdd.poker.cards.prepare.Set;

public class Three extends Combination {
    public Three(Set set) {
        super(set);
    }

    @Override
    public int compare(Combination comb) {
        int rank1;
        int rank2;

        rank1 = getThreeRank(this.set);
        rank2 = getThreeRank(comb.set);

        if (rank1 > rank2)
            return 1;
        if (rank1 < rank2)
            return -1;

        for (int i = 1; i < 3; i++) {
            rank1 = getHighestCardRank(this.set, i);
            rank2 = getHighestCardRank(comb.set, i);
            if (rank1 > rank2)
                return 1;
            if (rank1 < rank2)
                return -1;
        }
        return 0;
    }

    private int getThreeRank(Set set) {
        int rank = 0;

        for (int i = 0; i < 3; i++) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (set.getCard(i + 1).getDeckNumber() / 4 == rank)
                return rank;
        }
        return rank;
    }

    private int getHighestCardRank(Set set, int precedence) {
        int rank = 0;
        int count = 1;

        for (int i = 4; i > -1; i--) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (i == 0)
                return rank;
            if (set.getCard(i - 1).getDeckNumber() / 4 != rank) {
                if (count == precedence)
                    return rank;
                count++;
            } else
                i-=2;
        }
        return rank;
    }

    @Override
    public String toString() {
        return  "Three:" + '\n'
                + set.getCard(0).toString() + '\n'
                + set.getCard(1).toString() + '\n'
                + set.getCard(2).toString() + '\n'
                + set.getCard(3).toString() + '\n'
                + set.getCard(4).toString() + '\n';
    }
}
