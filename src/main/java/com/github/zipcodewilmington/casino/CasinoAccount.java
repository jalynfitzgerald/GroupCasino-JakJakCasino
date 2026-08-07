package com.github.zipcodewilmington.casino;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private int balance;
    public CasinoAccount() {
        balance = 250;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw (int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }

    public int getBalance () {
        return balance;
    }
}

