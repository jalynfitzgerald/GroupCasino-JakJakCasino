package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {

    private final String playerName;
    private final CasinoAccount account;

    private RouletteBetType betType;
    private int selectedNumber;
    private int betAmount;

    public RoulettePlayer(String playerName, CasinoAccount account) {
        this.playerName = playerName;
        this.account = account;
        this.selectedNumber = 0;
        this.betAmount = 0;
    }

    public boolean placeNumberBet(int selectedNumber, int betAmount) {
        if (account.withdraw(betAmount)) {
            this.betType = RouletteBetType.NUMBER;
            this.selectedNumber = selectedNumber;
            this.betAmount = betAmount;
            return true;
        }

        return false;
    }

    public boolean placeColorBet(RouletteBetType betType, int betAmount) {
        if (account.withdraw(betAmount)) {
            this.betType = betType;
            this.betAmount = betAmount;
            return true;
        }

        return false;
    }

    public String getPlayerName() {
        return playerName;
    }

    public RouletteBetType getBetType() {
        return betType;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public int getBetAmount() {
        return betAmount;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return account;
    }

    @Override
    public Boolean play() {
        return null;
    }
}
