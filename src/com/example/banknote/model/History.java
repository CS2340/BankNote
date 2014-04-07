package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

/**
 * History class contain the list of transactions associate with financial
 * account or a user account.
 * 
 * @author Nghia Huynh
 * 
 */

public class History {

    /*
     * ArrayList of transaction
     */
    /** The trans list. */
    private List<Transaction> transList;

    /**
     * Constructor for the history method.
     */
    public History() {
        transList = new ArrayList<Transaction>();
    }

    /**
     * Adds new transaction in the the Transaction List in the History.
     * 
     * @param newTrans
     *            : the new transaction added to the list.
     */
    public void addNewTrans(Transaction newTrans) {
        // add newTrans to the Transaction List
        transList.add(newTrans);
        DB.update(this);
    }

    /**
     * when account created, adds first transaction in the List as Initial
     * Balance.
     * 
     * @param amount initial balance amount.
     */
    public void setIntBalacce(double amount) {
        String initBalance = "Initial Balance";
        Transaction initialTransaction = new Transaction(initBalance,
                initBalance, true, amount);
        transList.add(initialTransaction);
        DB.update(this);
    }

    /**
     * Gets the last transaction.
     * 
     * @return the last transaction
     */
    public Transaction getLastTransaction() {
        int numOfTrans = transList.size();
        return transList.get(numOfTrans - 1);
    }

    /**
     * Gets the array list.
     * 
     * @return the array list
     */
    public List<Transaction> getArrayList() {
        return transList;
    }

}
