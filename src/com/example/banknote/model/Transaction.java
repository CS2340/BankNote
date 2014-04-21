package com.example.banknote.model;

import java.util.Date;

/**
 * Transaction class contain transactions' information under financial account
 * and user account.
 * 
 * @author Nghia Huynh
 * 
 */
public class Transaction {

    /**
     * A descriptive type for the transaction e.g shopping, gas, travels.. etc.
     */
    private String type;

    /** Description of the type of transaction. */
    private String description;

    /**
     * A income / outcome for the transaction true = income ; false = outcome.
     */
    private boolean isIncome;

    /**
     * The amount that deposit or withdraw from the account Note: negative
     * amount for outcome positive amount for income.
     */
    private double amount;

    /**
     * Recorded time when the user add the transaction.
     */
    private Date recordTime;

    /**
     * The target Financial account that the transaction belong to.
     */
    private Account targetAccount;

    /**
     * The target User that the transaction belong to.
     */
    private User targetUser;

    /**
     * Creates a transaction with uninitialized variables.
     */
    public Transaction() {
    }

    /**
     * Creates a transaction with initialized variables.
     * 
     * @param aDescription 
     *            : new description for the Transaction
     * @param aType
     *            : type of the transaction
     * @param isItIncome
     *            : income/outcome
     * @param anAmount
     * 
     *            : the amount of transaction
     */
    public Transaction(String aType, String aDescription, boolean isItIncome,
            double anAmount) {
        this.setType(aType);
        this.setDescription(aDescription);
        this.setIsIncome(isItIncome);
        this.setAmount(anAmount);
        this.setRecordedTime();
        this.setTargetAccount();
        this.setTargetUser();
    }

    /**
     * Sets the description of the Transaction.
     * @param aDescription the description of the transaction.
     */
    private void setDescription(String aDescription) {
        this.description = aDescription;
        DB.update(this);
    }

    /**
     *  
     * @param aType
     *            The type of the transaction
     */
    public void setType(String aType) {
        this.type = aType;
        DB.update(this);
    }

    /**
     * 
     * @param isItIncome
     *            income/outcome of the transaction
     */
    public void setIsIncome(boolean isItIncome) {
        this.isIncome = isItIncome;
        DB.update(this);
    }

    /**
     * Sets the amount of the transaction.
     * @param anAmount The amount of the transaction
     */
    public void setAmount(double anAmount) {
        this.amount = anAmount;
        DB.update(this);
    }

    /**
     * Sets recorded Time.
     */
    public void setRecordedTime() {
        this.recordTime = new Date();
        DB.update(this);
    }

    /**
     * Sets target account.
     */
    public void setTargetAccount() {
        this.targetAccount = AccountSingle.getCurrentAccount();
        DB.update(this);
    }

    /**
     * sets the targetUser variable.
     */
    public void setTargetUser() {
        this.targetUser = UserSingle.getCurrentUser();
        DB.update(this);
    }

    /**
     * 
     * @return (String) the type of the transaction.
     */
    public String getType() {
        return this.type;
    }

    /**
     * 
     * @return (String) the description of the transaction.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @return (boolean) the income/outcome of the transaction true = income /
     *         false = outcome.
     */
    public boolean getIsIncome() {
        return this.isIncome;
    }

    /**
     * 
     * @return (double) the amount of the transaction.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * 
     * @return (Date) the recorded time of the transaction.
     */
    public Date getRecordedTime() {
        return this.recordTime;
    }

    /**
     * 
     * @return (Account) the financial account of the transaction.
     */
    public Account getTargetAccount() {
        return this.targetAccount;
    }

    /**
     * 
     * @return (User) the user account of the transaction belongs to.
     */
    public User getTargetUser() {
        return this.targetUser;
    }

}
