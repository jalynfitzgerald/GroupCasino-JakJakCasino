package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlackjackGameTest {

    @Test
    public void dealInitialCards_dealsTwoCardsToPlayerAndDealer() {
        BlackjackPlayer dealer = new BlackjackPlayer(new CasinoAccount());
        BlackjackPlayer player = new BlackjackPlayer(new CasinoAccount());
        BlackjackGame game = new BlackjackGame(1, dealer);

        game.add(player);
        game.dealInitialCards();

        assertEquals(2, player.getHand().size());
        assertEquals(2, dealer.getHand().size());
        assertTrue(player.getHandValue() >= 4 && player.getHandValue() <= 21);
        assertTrue(dealer.getHandValue() >= 4 && dealer.getHandValue() <= 21);
        assertEquals(48, game.cardsRemainingInShoe());
    }

    @Test
    public void dealInitialCards_resetsHandsBeforeDealingAgain() {
        BlackjackPlayer dealer = new BlackjackPlayer(new CasinoAccount());
        BlackjackPlayer player = new BlackjackPlayer(new CasinoAccount());
        BlackjackGame game = new BlackjackGame(1, dealer);

        game.add(player);
        game.dealInitialCards();
        game.dealInitialCards();

        assertEquals(2, player.getHand().size());
        assertEquals(2, dealer.getHand().size());
    }
}
