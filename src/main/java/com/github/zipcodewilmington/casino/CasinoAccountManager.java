package com.github.zipcodewilmington.casino;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    private final Map<String, CasinoAccount> accountByName = new HashMap<>();


    private final Map<String, CasinoAccount> accounts = new HashMap<>();

    public CasinoAccount getAccount(String accountName, String accountPassword) {
        CasinoAccount account = accountByName.get(accountName);
        if (account == null) {
            return null;
        }
        if (!account.isPasswordMatch(accountPassword)) {
            return null;
        }
        return account;
public class CasinoAccountManager {

    private final Map<String, CasinoAccount> accounts = new HashMap<>();

    public CasinoAccount getAccount(String accountName, String accountPassword) {

        CasinoAccount account = accounts.get(accountName);

        if (account != null && account.checkPassword(accountPassword)) {
            return account;
        }

        return null;
    }

    public CasinoAccount createAccount(String accountName, String accountPassword) {
        return new CasinoAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        if (casinoAccount == null) {
            throw new IllegalArgumentException("Cannot register a null account");
        }
        accountByName.put(casinoAccount.getAccountName(), casinoAccount);

        if (accounts.containsKey(accountName)) {
            return null;
        }

        CasinoAccount account =
                new CasinoAccount(accountName, accountPassword);

        registerAccount(accountName, account);

        return account;
    }

    public void registerAccount(String accountName,
                                CasinoAccount casinoAccount) {

        accounts.put(accountName, casinoAccount);
    }
}