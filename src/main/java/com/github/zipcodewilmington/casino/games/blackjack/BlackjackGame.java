package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame implements GameInterface {
    private final Shoe shoe;
    private final BlackjackPlayer dealer;
    private final List<BlackjackPlayer> players;

    public BlackjackGame() {
        this(1, new BlackjackPlayer(new CasinoAccount()));
    }

    public BlackjackGame(int numberOfDecks, BlackjackPlayer dealer) {
        this.shoe = new Shoe(numberOfDecks);
        this.dealer = dealer;
        this.players = new ArrayList<>();
        this.shoe.shuffle();
    }

    @Override
    public void add(PlayerInterface player) {
        if (player instanceof BlackjackPlayer) {
            add((BlackjackPlayer) player);
        }
    }

    public void add(BlackjackPlayer player) {
        if (player != null) {
            players.add(player);
        }
    }

    @Override
    public void remove(PlayerInterface player) {
        if (player instanceof BlackjackPlayer) {
            players.remove(player);
        }
    }

    @Override
    public void run() {
        dealInitialCards();
    }

    public void dealInitialCards() {
        for (BlackjackPlayer player : players) {
            player.clearHand();
        }
        dealer.clearHand();

        for (int i = 0; i < 2; i++) {
            for (BlackjackPlayer player : players) {
                player.addCard(shoe.deal());
            }
            dealer.addCard(shoe.deal());
        }
    }

    public int cardsRemainingInShoe() {
        return shoe.size();
    }
}
