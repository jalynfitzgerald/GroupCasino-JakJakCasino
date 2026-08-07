package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.cards.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoeTest {

    @Test
    public void constructorWithOneDeck_has52Cards() {
        Shoe shoe = new Shoe(1);
        assertEquals(52, shoe.size());
    }

    @Test
    public void constructorWithMultipleDecks_hasExpectedCardCount() {
        Shoe shoe = new Shoe(6);
        assertEquals(312, shoe.size());
    }

    @Test
    public void deal_reducesShoeSizeByOne() {
        Shoe shoe = new Shoe(1);
        int before = shoe.size();
        Card card = shoe.deal();

        assertNotNull(card);
        assertEquals(before - 1, shoe.size());
    }

    @Test
    public void constructorWithZeroDecks_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Shoe(0));
    }
}
