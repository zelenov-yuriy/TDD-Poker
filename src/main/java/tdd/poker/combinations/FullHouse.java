package tdd.poker.combinations;

import tdd.poker.Set;

public class FullHouse extends Combination {
    public FullHouse(Set set) {
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

        rank1 = getPairRank(this.set);
        rank2 = getPairRank(comb.set);

        if (rank1 > rank2)
            return 1;
        if (rank1 < rank2)
            return -1;

        return 0;
    }

    private int getThreeRank(Set set) {
        int rank = 0;

        for (int i = 0; i < 3; i+=2) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (set.getCard(i + 1).getDeckNumber() / 4 == rank &&
                set.getCard(i + 2).getDeckNumber() / 4 == rank)
                    return rank;
        }
        return rank;
    }

    private int getPairRank(Set set) {
        int rank = 0;

        for (int i = 0; i < 4; i+=3) {
            rank = set.getCard(i).getDeckNumber() / 4;
            if (i == 3)
                return rank;
            if (set.getCard(i + 1).getDeckNumber() / 4 == rank &&
                    set.getCard(i + 2).getDeckNumber() / 4 != rank)
                return rank;
        }
        return rank;
    }

    @Override
    public String toString() {
        return  "FullHouse:"
                + set.getCard(0).toString() + '\n'
                + set.getCard(1).toString() + '\n'
                + set.getCard(2).toString() + '\n'
                + set.getCard(3).toString() + '\n'
                + set.getCard(4).toString() + '\n';
    }
}
