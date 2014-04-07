package com.example.banknote.model;

/**
 * The Class AccountSingle.
 */
public class AccountSingle {

    /** The instance. */
    private static AccountSingle instance;

    /** The current account. */
    private static Account currentAccount;

    /**
     * Instantiates a new account single.
     */
    private AccountSingle() {

    }

    /**
     * Instantiates a new account single.
     * 
     * @param account
     *            the account
     */
    private AccountSingle(Account account) {
        currentAccount = account;
    }

    /**
     * Gets the single instance of AccountSingle.
     * 
     * @return single instance of AccountSingle
     */
    public static AccountSingle getInstance() {
        if (instance == null) {
            instance = new AccountSingle();
        }
        return instance;
    }

    /**
     * Gets the current account.
     * 
     * @return the current account
     */
    public static Account getCurrentAccount() {
        return currentAccount;
    }

    /**
     * Sets the current account.
     * 
     * @param account
     *            the new current account
     */
    public static void setCurrentAccount(Account account) {
        currentAccount = account;
    }

}
