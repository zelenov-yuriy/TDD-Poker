package tdd.poker.combinations;

import tdd.poker.Set;

public class Four extends Combination {
    public Four(Set set) {
        super(set);
    }

    @Override
    public int compare(Combination comb) {
        int rank1;
        int rank2;

        rank1 = getFourRank(this.set);
        rank2 = getFourRank(comb.set);

        if (rank1 > rank2)
            return 1;
        if (rank1 < rank2)
            return -1;

        rank1 = getHighestCardRank(this.set);
        rank2 = getHighestCardRank(comb.set);

        if (rank1 > rank2)
            return 1;
        if (rank1 < rank2)
            return -1;

        return 0;
    }

    private int getFourRank(Set set) {
        int rank = 0;

        for (int i = 0; i < 2; i++) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (set.getCard(i + 1).getDeckNumber() / 4 == rank)
                return rank;
        }
        return rank;
    }

    private int getHighestCardRank(Set set) {
        int rank = 0;

        for (int i = 0; i < 5; i+=4) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (i == 4)
                return rank;
            if (set.getCard(i + 1).getDeckNumber() / 4 != rank)
                return rank;
        }
        return rank;
    }

    @Override
    public String toString() {
        return  "Four:"
                + set.getCard(0).toString() + '\n'
                + set.getCard(1).toString() + '\n'
                + set.getCard(2).toString() + '\n'
                + set.getCard(3).toString() + '\n'
                + set.getCard(4).toString() + '\n';
    }
}
