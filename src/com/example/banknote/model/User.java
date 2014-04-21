package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Synonymous with "User Account" each has a name and password.
 * 
 * @author jacksonkmillsaps
 * 
 */
public class User {

    /** The name. */
    private String name;
    
    /** The password. */
    private String password;
    
    /** The accounts. */
    private ArrayList<Account> accounts;
    


    /*
     * ArrayList of transaction
     */
    /** The transaction list. */
    private ArrayList<Transaction> transactionList;

    /**
     * Creates a new user with a name and password.
     * 
     * @param aName name of the new user
     * @param aPassword password of the new user
     */
    public User(String aName, String aPassword) {
        this.name = aName;
        this.password = aPassword;
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Creates a new user with null string name and password.
     */
    public User() {
        name = "";
        password = "";
        this.accounts = new ArrayList<Account>();
    }

    /**
     * gets the name of the user.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * gets the password of the user.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the name of the user.
     * 
     * @param aName the new name
     */
    public void setName(String aName) {
        this.name = aName;
        DB.update(this);
    }

    /**
     * Sets the password of the user
     * 
     * @param aPassword the new password
     */
    public void setPassword(String aPassword) {
        this.password = aPassword;
        DB.update(this);
    }

    /**
     * Adds a new account to the users accounts.
     * 
     * @param anAccount account to be added.
     */
    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
        DB.update(this);
    }
    
    
    /**
     * Returns a list of the user's accounts.
     * 
     * @return the list of accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Name equals.
     * 
     * @param u1
     *            the u1
     * @param u2
     *            the u2
     * @return true, if successful
     */
    public static boolean nameEquals(User u1, User u2) {
        if (u1.getName().equals(u2.getName())) {
            return true;
        }
        return false;
    }

    /**
     * Gets the account by display.
     * 
     * @param aName
     *            the name
     * @return the account by display
     */
    public Account getAccountByDisplay(String aName) {
        for (Account a : accounts) {
            if (a.getDisplayName().equals(aName)) {
                return a;
            }
        }
        return null;

    }
}
