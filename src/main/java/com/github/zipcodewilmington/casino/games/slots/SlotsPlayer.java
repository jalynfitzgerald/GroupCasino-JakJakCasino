package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    private final String playerName;
    private final CasinoAccount account;

    public SlotsPlayer() {
        this("Slots Player", new CasinoAccount());
    }

    public SlotsPlayer(String playerName, CasinoAccount account) {
        this.playerName = playerName;
        this.account = account;
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
}