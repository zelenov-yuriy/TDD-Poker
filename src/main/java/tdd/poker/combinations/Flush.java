package tdd.poker.combinations;

import tdd.poker.Set;

public class Flush extends Combination {
    public Flush(Set set) {
        super(set);
    }

    @Override
    public int compare(Combination comb) {
        int rank1;
        int rank2;

        for (int i = 4; i >= 0; i--) {
            rank1 = set.getCard(i).getDeckNumber() / 4;
            rank2 = comb.set.getCard(i).getDeckNumber() / 4;
            if (rank1 > rank2)
                return 1;
            if (rank1 < rank2)
                return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "Flush:"
                + set.getCard(0).toString() + '\n'
                + set.getCard(1).toString() + '\n'
                + set.getCard(2).toString() + '\n'
                + set.getCard(3).toString() + '\n'
                + set.getCard(4).toString() + '\n';
    }
}
