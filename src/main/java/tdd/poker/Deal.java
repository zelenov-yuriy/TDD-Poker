package tdd.poker;

import tdd.poker.cards.prepare.*;
import tdd.poker.combinations.*;

public class Deal {
    private Deck deck;
    private Set[] sets;
    private Combination[] combs;
    private boolean[] winners;
    private int numOfWinners;
    private int[] combPriorities;
    private int maxCombPriority;


    public Deal() {
        deck = new Deck();
        deck.shuffle();
        sets = new Set[3];
        sets[0] = new Set(deck.getCard(0), deck.getCard(1), deck.getCard(2), deck.getCard(3), deck.getCard(4));
        sets[1] = new Set(deck.getCard(5), deck.getCard(6), deck.getCard(7), deck.getCard(8), deck.getCard(9));
        sets[2] = new Set(deck.getCard(10), deck.getCard(11), deck.getCard(12), deck.getCard(13), deck.getCard(14));
        combs = new Combination[3];
        combPriorities = new int[3];
        winners = new boolean[3];
    }
    public void setCombs() {
        combs[0] = setCombination(sets[0]);
        combs[1] = setCombination(sets[1]);
        combs[2] = setCombination(sets[2]);
    }

    public Combination setCombination(Set set) {
        switch(set.recognize()) {
            case 1:
                return new Pair(set);
            case 2:
                return new TwoPairs(set);
            case 3:
                return new Three(set);
            case 4:
                return new Straight(set);
            case 5:
                return new Flush(set);
            case 6:
                return new FullHouse(set);
            case 7:
                return new Four(set);
            case 8:
                return new StraightFlush(set);
            default:
                return new HighestCard(set);
        }
    }

    public void showCombs() {
        for(Combination combination: combs)
            System.out.println(combination);
    }

    public void setWinners() {
        setCombPriorities();
        determineMaxCombPriority();
        setPlayersWithMaxCombPriority();
        if (numOfWinners > 1)
            thinOutWinners();
    }

    public void setCombPriorities() {
        for (int i = 0; i < combs.length; i++)
            combPriorities[i] = combs[i].getCombPriority();
    }

    public void determineMaxCombPriority() {
        for (int i : combPriorities)
            if (i > maxCombPriority)
                maxCombPriority = i;
    }

    public void setPlayersWithMaxCombPriority() {
        for (int i = 0; i < winners.length; i++)
            if (combPriorities[i] == maxCombPriority) {
                winners[i] = true;
                numOfWinners++;
            }
    }

    public void thinOutWinners() {
        int i = 0;
        while (!winners[i])
            i++;
        Combination bestComb = combs[i];
        do {
            i++;
            if (winners[i])
                switch (combs[i].compare(bestComb)) {
                    case -1:
                        winners[i] = false;
                        break;
                    case 1:
                        for (int j = 0; j < i; j++)
                            winners[j] = false;
                        break;
                }
        } while (i < winners.length - 1);
    }

    public void showWinners() {
        for(boolean result : winners)
            System.out.println(result);
    }
}
