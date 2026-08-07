package com.github.zipcodewilmington.casino.games.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.github.zipcodewilmington.casino.CasinoAccount;

public class BlackjackGameTest {

    @Test
    public void dealInitialCards_dealsTwoCardsToPlayerAndDealer() {
        BlackjackPlayer dealer = new BlackjackPlayer(new CasinoAccount());
        BlackjackPlayer player = new BlackjackPlayer(new CasinoAccount());
        BlackjackGame game = new BlackjackGame(5, dealer);

        game.add(player);
        game.dealInitialCards();

        assertEquals(2, player.getHand().size());
        assertEquals(2, dealer.getHand().size());
        assertEquals(48, game.cardsRemainingInShoe());
    }
}
