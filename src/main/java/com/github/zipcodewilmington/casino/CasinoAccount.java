package com.github.zipcodewilmington.casino;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private final String accountName;
    private final String accountPassword;
    private final String accountReference;
    private BigDecimal balance;

    public CasinoAccount() {
        this("", "");
    }

    public CasinoAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.accountReference = UUID.randomUUID().toString();
        this.balance = BigDecimal.ZERO;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public boolean isPasswordMatch(String attemptedPassword) {
        return accountPassword.equals(attemptedPassword);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
    }

    public boolean withdraw(BigDecimal amount) {
        if (amount == null || amount.signum() <= 0) {
            return false;
        }
        if (balance.compareTo(amount) < 0) {
            return false;
        }
        balance = balance.subtract(amount);
        return true;
    }
}
