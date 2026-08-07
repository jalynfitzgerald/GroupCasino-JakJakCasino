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

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        CasinoAccount account = accountByName.get(accountName);
        if (account == null) {
            return null;
        }
        if (!account.isPasswordMatch(accountPassword)) {
            return null;
        }
        return account;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
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
    }
}
