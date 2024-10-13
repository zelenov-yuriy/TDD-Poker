package tdd.poker;

import tdd.poker.cards.prepare.*;
import tdd.poker.combinations.*;

public class Player {
    private int number;
    private Combination combination;

    public Player (int number) {
        this.number = number;
    }

    public void setCombination(Set set) {
        switch(set.recognize()) {
            case 0:
                combination = new HighestCard(set);
                break;
            case 1:
                combination = new Pair(set);
                break;
            case 2:
                combination = new TwoPairs(set);
                break;
            case 3:
                combination = new Three(set);
                break;
            case 4:
                combination = new Straight(set);
                break;
            case 5:
                combination = new Flush(set);
                break;
            case 6:
                combination = new FullHouse(set);
                break;
            case 7:
                combination = new Four(set);
                break;
            case 8:
                combination = new StraightFlush(set);
                break;
        }
    }

    public Combination getCombination() {
        return combination;
    }

    public void showCombination() {
        System.out.println(number + " player's combination: ");
        System.out.println(combination);
    }

    public int getCombPriority() {
        return combination.getCombPriority();
    }
}
