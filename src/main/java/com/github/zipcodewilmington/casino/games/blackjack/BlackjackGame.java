package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackjackGame implements GameInterface {
    private final List<BlackjackPlayer> players;
    private final BlackjackPlayer dealer;
    private final Shoe shoe;

    public BlackjackGame(int numberOfDecks, BlackjackPlayer dealer) {
        this.players = new ArrayList<>();
        this.shoe = new Shoe(numberOfDecks);
        this.shoe.shuffle();
        this.dealer = dealer;
    }

    @Override
    public void add(PlayerInterface player) {
        if (player instanceof BlackjackPlayer) {
            players.add((BlackjackPlayer) player);
        }
    }

    @Override
    public void remove(PlayerInterface player) {
        if (player instanceof BlackjackPlayer) {
            players.remove(player);
        }
    }
    public Card dealFromShoe() {
        return shoe.deal();
    }

    public int cardsRemainingInShoe() {
        return shoe.size();
    }

    public void dealInitialCards() {
        for (int round = 0; round < 2; round++) {
            for (BlackjackPlayer player : players) {
                player.addCard(dealFromShoe());
            }
            dealer.addCard(dealFromShoe());
        }
    }

    @Override
    public void run() {
        dealInitialCards();
    }
}