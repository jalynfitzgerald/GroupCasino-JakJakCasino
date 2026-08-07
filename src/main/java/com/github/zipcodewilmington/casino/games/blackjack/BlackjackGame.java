package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.cards.Card;

public class BlackjackGame implements GameInterface {

    private final List<BlackjackPlayer> players;
    private final BlackjackPlayer dealer;
    private final Shoe shoe;

    public BlackjackGame() {
    this.players = new ArrayList<>();
    this.shoe = new Shoe(6);
    this.shoe.shuffle();

    CasinoAccount dealerAccount = new CasinoAccount(/* whatever your constructor requires */);
    this.dealer = new BlackjackPlayer("Dealer", dealerAccount);
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
        dealer.clearHand();

        for (BlackjackPlayer player : players) {
            player.clearHand();
        }

        for (int round = 0; round < 2; round++) {

            for (BlackjackPlayer player : players) {
                player.addCard(dealFromShoe());
            }

            dealer.addCard(dealFromShoe());
        }
    }

    public Card hit(BlackjackPlayer player) {

        Card card = dealFromShoe();

        if (card != null) {
            player.addCard(card);
        }

        return card;
    }

    public boolean isBusted(BlackjackPlayer player) {
        return player.getHandValue() > 21;
    }

    public void playDealerTurn() {

        while (dealer.getHandValue() < 17) {
            hit(dealer);
        }
    }

    public String determineWinner(BlackjackPlayer player) {

        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        if (playerValue > 21) {
            return "Dealer";
        }

        if (dealerValue > 21) {
            return player.getPlayerName();
        }

        if (playerValue > dealerValue) {
            return player.getPlayerName();
        }

        if (dealerValue > playerValue) {
            return "Dealer";
        }

        return "Push";
    }

    public BlackjackPlayer getDealer() {
        return dealer;
    }

    public List<BlackjackPlayer> getPlayers() {
        return new ArrayList<>(players);
    }

    @Override
    public void run() {

        dealInitialCards();

        for (BlackjackPlayer player : players) {

            if (!isBusted(player)) {
                playDealerTurn();
            }

            String winner = determineWinner(player);

            System.out.println(
                    player.getPlayerName()
                            + ": "
                            + player.getHandValue()
                            + " | Dealer: "
                            + dealer.getHandValue()
            );

            System.out.println("Winner: " + winner);
        }
    }
}