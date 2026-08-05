package com.github.zipcodewilmington.casino.games.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe {
    private final List<Card> cards;

    public Shoe(int numberOfDecks) {
        if (numberOfDecks < 1) {
            throw new IllegalArgumentException("numberOfDecks must be at least 1");
        }
        this.cards = new ArrayList<>();
        initialize(numberOfDecks);
    }

    private void initialize(int numberOfDecks) {
        cards.clear();
        for (int i = 0; i < numberOfDecks; i++) {
            Deck deck = new Deck();
            cards.addAll(deck.getCards());
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}
