package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {

    private final String playerName;
    private final CasinoAccount account;

    public NumberGuessPlayer() {
        this("Number Guess Player",
                new CasinoAccount("Number Guess Player", ""));
    }

    public NumberGuessPlayer(String playerName, CasinoAccount account) {
        this.playerName = playerName;
        this.account = account;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return account;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
