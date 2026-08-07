package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.cards.Card;
import com.github.zipcodewilmington.casino.cards.Rank;

import java.util.ArrayList;
import java.util.List;

public class BlackjackPlayer implements PlayerInterface {
    private final String playerName;
    private final CasinoAccount account;
    private final List<Card> hand;

    public BlackjackPlayer(CasinoAccount account) {
        this("Blackjack Player", account);
    }

    public BlackjackPlayer(String playerName, CasinoAccount account) {
        this.playerName = playerName;
        this.account = account;
        this.hand = new ArrayList<>();
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return account;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public void addCard(Card card) {
        if (card != null) {
            hand.add(card);
        }
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public void clearHand() {
        hand.clear();
    }

    public int getHandValue() {
        int total = 0;
        int aces = 0;
        for (Card card : hand) {
            total += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aces++;
            }
        }
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }
}
