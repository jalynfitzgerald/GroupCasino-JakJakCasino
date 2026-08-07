package com.github.zipcodewilmington.casino;

import java.util.HashMap;
import java.util.Map;

public class CasinoAccountManager {

    private final Map<String, CasinoAccount> accountByName = new HashMap<>();

    public CasinoAccount getAccount(String accountName, String accountPassword) {

        CasinoAccount account = accountByName.get(accountName);

        if (account == null) {
            return null;
        }

        if (!account.checkPassword(accountPassword)) {
            return null;
        }

        return account;
    }

    public CasinoAccount createAccount(String accountName, String accountPassword) {

        if (accountByName.containsKey(accountName)) {
            return null;
        }

        CasinoAccount account =
                new CasinoAccount(accountName, accountPassword);

        registerAccount(account);

        return account;
    }

    public void registerAccount(CasinoAccount casinoAccount) {

        if (casinoAccount == null) {
            throw new IllegalArgumentException("Cannot register a null account");
        }

        accountByName.put(
                casinoAccount.getUsername(),
                casinoAccount
        );
    }
}