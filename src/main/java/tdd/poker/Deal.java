package tdd.poker;

import tdd.poker.cards.prepare.*;
import tdd.poker.combinations.*;

public class Deal {
    private Deck deck;
    private Set[] sets;
    private Player[] players;
    private boolean[] winners;
    private int numOfWinners;
    private int[] combPriorities;
    private int maxCombPriority;


    public Deal(int numOfPlayers) {
        deck = new Deck();
        deck.shuffle();
        sets = new Set[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++)
            sets[i] = new Set(deck.getCard(i * 5), deck.getCard(i * 5 + 1), deck.getCard(i * 5 + 2),
                    deck.getCard(i * 5 + 3), deck.getCard(i * 5 + 4));
        players = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++)
            players[i] = new Player(i);
        combPriorities = new int[numOfPlayers];
        winners = new boolean[numOfPlayers];
    }

    public void setPlayersCombs() {
        for (int i = 0; i < players.length; i++)
            players[i].setCombination(sets[i]);
    }

    public void showPlayersCombs() {
        for (Player player : players)
            player.showCombination();
    }

    public void setWinners() {
        setCombPriorities();
        determineMaxCombPriority();
        setPlayersWithMaxCombPriority();
        if (numOfWinners > 1)
            thinOutWinners();
    }

    public void setCombPriorities() {
        for (int i = 0; i < players.length; i++)
            combPriorities[i] = players[i].getCombPriority();
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
        Combination bestComb = players[i].getCombination();
        do {
            i++;
            if (winners[i])
                switch (players[i].getCombination().compare(bestComb)) {
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
        for (boolean result : winners)
            System.out.println(result);
    }
}
