package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates a financial account.
 * 
 * @author jacksonkmillsaps
 * 
 */

public class Account implements Comparable<Account> {
    /**
     * A descriptive name for the account.
     */
    private String fullName;
    
    /**
     * The name that will be displayed (should be optional and default to full.
     * name)
     */
    private String displayName;
    /**
     * current account balance.
     */
    private double balance;

    /**
     * Annual interest rate (optional, should default to 0).
     */
    private double interestRate;

    /**
     * A History object that store transaction information.
     * 
     * @Editted by Nghia Huynh
     */
    private History transHistory = new History();
    
    /** The trans. */
    private List<Transaction> trans;

    /**
     * 
     * @param aFullName
     *            A descriptive name for the account
     * @param aDisplayName
     *            The name that will be displayed (should be optional and
     *            default to full name)
     * @param aBalance
     *            initial balance
     * @param anInterestRate
     *            Annual interest rate (optional, should default to 0)
     */
    public Account(String aFullName, String aDisplayName, double aBalance,
            double anInterestRate) {
        fullName = aFullName;
        displayName = aDisplayName;
        balance = aBalance;
        interestRate = anInterestRate;
        trans = new ArrayList<Transaction>();
    }

    /**
     * Creates an account with uninitialized variables.
     */
    public Account() {
        trans = new ArrayList<Transaction>();
    }

    /**
     * 
     * @param aFullName A descriptive name for the account
     */
    public void setFullName(String aFullName) {
        this.fullName = aFullName;
        // since display name is optional, it defaults to full name if not yet
        // set
        if (displayName == null) {
            displayName = fullName;
        }
        DB.update(this);
    }

    /**
     * 
     * @param aDisplayName The name that will be displayed
     */
    public void setDisplayName(String aDisplayName) {
        displayName = aDisplayName;
        DB.update(this);
    }

    /**
     * 
     * @param aBalance the amount to set balance to
     */
    public void setBalance(double aBalance) {
        balance = aBalance;
        DB.update(this);
    }

    /**
     * 
     * @param anInterestRate annual interest rate
     */
    public void setInterestRate(double anInterestRate) {
        interestRate = anInterestRate;
        DB.update(this);
    }

    /**
     * 
     * @return the full name of the account
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @return the display name for the account
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 
     * @return the interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * 
     * @return the History
     */
    public History getHistory() {
        return transHistory;
    }

    /**
     * Gets the trans.
     * 
     * @return the trans
     */
    public List<Transaction> getTrans() {
        return trans;
    }

    /**
     * Update account's balance with the last recent transaction added.
     * 
     * @param amount Amount to change the balance by.
     */
    public void updateBalance(double amount) {
        balance += amount;
        DB.update(this);
    }

    /**
     * Compares the balance of this account to another.
     * 
     * @param other the Account to which we are comparing
     * @return 0 if equal, positive if this balance is bigger, negative if other
     *         balance is bigger
     */
    public int compareTo(Account other) {
        Double difference = balance - other.getBalance();
        return difference.compareTo(0.0);
    }

    /**
     * Adds the new trans.
     * 
     * @param newTrans
     *            the new trans
     */
    public void addNewTrans(Transaction newTrans) {
        trans.add(newTrans);

    }
        
    public String toString()
    {
    	return displayName;
    }
}
