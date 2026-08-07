package com.github.zipcodewilmington.casino.games.roulette;

import java.math.BigDecimal;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {

    private CasinoAccount account;
    private int selectedNumber;
    private int betAmount;
    private RouletteBetType betType;

    public RoulettePlayer(CasinoAccount account) {
        this.account = account;
        this.selectedNumber = 0;
        this.betAmount = 0;
        this.betType = RouletteBetType.NUMBER;
    }

    public boolean placeBet(RouletteBetType betType,
                            int selectedNumber,
                            int betAmount) {

        if (account.withdraw(BigDecimal.valueOf(betAmount))) {

            this.betType = betType;
            this.selectedNumber = selectedNumber;
            this.betAmount = betAmount;

            return true;
        }

        return false;
    }

    @Override
    public CasinoAccount getCasinoAccount() {
        return account;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public RouletteBetType getBetType() {
        return betType;
    }
}