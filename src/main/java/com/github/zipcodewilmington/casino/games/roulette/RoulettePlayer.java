package com.github.zipcodewilmington.casino.games.roulette;

import java.math.BigDecimal;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {

    private CasinoAccount account;
    private int selectedNumber;
    private int betAmount;

    public RoulettePlayer(CasinoAccount account) {
    this.account = account;
    this.selectedNumber = 0;
    this.betAmount = 0;
}
public boolean placeBet(int selectedNumber, int betAmount) {
    if (account.withdraw(BigDecimal.valueOf(betAmount))) {
        this.selectedNumber = selectedNumber;
        this.betAmount = betAmount;
        return true;
    }
    return false;
}
@Override
public CasinoAccount getArcadeAccount() {
    return account;
}

@Override
public Boolean play() {
    return null;
}
}