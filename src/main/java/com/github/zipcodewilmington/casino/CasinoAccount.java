package com.github.zipcodewilmington.casino;

public class CasinoAccount {

    private final String username;
    private final String password;
    private int balance;

    public CasinoAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 250;
    }

    public CasinoAccount() {
        //TODO Auto-generated constructor stub
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

