package com.example.banknote.model;

import iModel.iAddFinAccountModel;

import java.util.ArrayList;

/**
 * The Class AddAccountHandler.
 */
public class AddAccountHandler implements iAddFinAccountModel 
{
    
    /** The accounts. */
    private ArrayList<Account> accounts;

    /**
     * Checks if is valid name.
     * 
     * @param name the name
     * @return true, if is valid name
     */
    public  boolean isValidName(String name) {
        return !(name == null || name.equals(""));
    }

    /**
     * Name already exists.
     * 
     * @param fullName
     *            the full name
     * @param displayName
     *            the display name
     * @return true, if successful
     */
    public  boolean nameAlreadyExists(String fullName, String displayName) {
        if (accounts == null) {
            return false;
        }

        for (Account a : accounts) {
            if (a == null) {
                return false;
            }
            if (a.getFullName().equals(fullName)
                    || a.getDisplayName().equals(displayName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if is valid interest rate.
     * 
     * @param ir
     *            the ir
     * @return true, if is valid interest rate
     */
    public  boolean isValidInterestRate(String ir) {
        if ((ir == null || ir.equals(""))) {
            return true;
        }

        double irDouble = Double.parseDouble(ir);

        return !(irDouble < 0);
    }

    /**
     * Checks if is valid amount.
     * 
     * @param amount
     *            the amount
     * @return true, if is valid amount
     */
    public  boolean isValidAmount(String amount) {
        if (amount == null || amount.equals("")) {
            return false;
        }

        return (amount.matches("[0-9]*\\.[0-9]{2}") || amount.matches("[0-9]*"));
    }

    /**
     * Adds the account.
     * 
     * @param fullName
     *            the full name
     * @param displayName
     *            the display name
     * @param balance
     *            the balance
     * @param interestRate
     *            the interest rate
     */
    public  void addAccount(String fullName, String displayName,
            String balance, String interestRate) {
        double balanceDouble = Double.parseDouble(balance);
        String newDisplayName = displayName; 

        double irDouble;
        if (interestRate == null || interestRate.equals("")) {
            irDouble = 0;
        } else {
            irDouble = Double.parseDouble(interestRate);
        }

        if (displayName == null || displayName.equals("")) {
            newDisplayName = fullName;
        }

        Account account = new Account(fullName, newDisplayName, balanceDouble,
                irDouble);

        // Add the new account into Accounts List of current user.
        User currentUser = UserSingle.getCurrentUser();
        currentUser.addAccount(account);

        AccountSingle.getInstance();
        AccountSingle.setCurrentAccount(account);

        // Set initial balance for the new account (Transaction)
        account.getHistory().setIntBalacce(balanceDouble);
        
        account.setIntBalacce(balanceDouble);
        
    }

}
