package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class CasinoAccountManagerTest {

    @Test
    public void createAndRegisterAccount_allowsLoginLookup() {
        CasinoAccountManager manager = new CasinoAccountManager();
        CasinoAccount account = manager.createAccount("player-one", "s3cret");
        manager.registerAccount(account);

        CasinoAccount actual = manager.getAccount("player-one", "s3cret");

        assertSame(account, actual);
        assertNotNull(actual.getAccountReference());
    }

    @Test
    public void getAccount_withWrongPassword_returnsNull() {
        CasinoAccountManager manager = new CasinoAccountManager();
        CasinoAccount account = manager.createAccount("player-one", "s3cret");
        manager.registerAccount(account);

        CasinoAccount actual = manager.getAccount("player-one", "wrong-password");

        assertNull(actual);
    }

    @Test
    public void playersStoreNameAndLoggedInAccountReference() {
        CasinoAccount account = new CasinoAccount("lucky-player", "pw");
        SlotsPlayer slotsPlayer = new SlotsPlayer("Lucky", account);
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer("Lucky", account);

        assertEquals("Lucky", slotsPlayer.getPlayerName());
        assertEquals("Lucky", numberGuessPlayer.getPlayerName());
        assertSame(account, slotsPlayer.getArcadeAccount());
        assertSame(account, numberGuessPlayer.getArcadeAccount());
    }
}
