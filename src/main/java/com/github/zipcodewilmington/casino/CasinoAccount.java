package com.github.zipcodewilmington.casino;

public class CasinoAccount {

    private final String username;
    private final String password;
    private int balance;

    // Constructor used when creating a new account
    public CasinoAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 250; // Starting balance
    }

    // Default constructor
    public CasinoAccount() {
        this("", "");
    }

    // Add money to the account
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Remove money from the account
    public boolean withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Return current balance
    public int getBalance() {
        return balance;
    }

    // Return username
    public String getUsername() {
        return username;
    }

    // Check if password matches
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}