package com.github.zipcodewilmington.casino;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CasinoAccountTest {
    @Test
    public void constructorWithNoArguments_defaultsBankAccountToNull() {
        CasinoAccount casinoAccount = new CasinoAccount();

        assertNull(casinoAccount.getBankAccount());
    }

    @Test
    public void constructorWithBankAccount_setsBankAccount() {
        BankAccount bankAccount = new BankAccount();
        CasinoAccount casinoAccount = new CasinoAccount(bankAccount);

        assertNotNull(casinoAccount.getBankAccount());
        assertSame(bankAccount, casinoAccount.getBankAccount());
    }
}
