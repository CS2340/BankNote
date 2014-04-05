package com.example.banknote.model;

import java.util.Date;

/**
 * Transaction class contain transactions' information under financial account and user account.
 * @author Nghia Huynh
 *
 */
public class Transaction {
	
	/*
	 * A descriptive type for the transaction
	 * e.g shopping, gas, travels.. etc. 
	 */
	private String type;
	
	
	
	private String description; 
	
	/*
	 * A income / outcome for the transaction
	 * true = income ; false = outcome
	 */
	private boolean isIncome;
	
	/*
	 * The amount that deposit or withdraw from the account
	 * Note:
	 * 		negative amount for outcome
	 * 		positive amount for income
	 */
	private double amount;
	
	/*
	 * Recorded time when the user add the transaction.
	 */
	private Date recordTime;
	
	/*
	 * The target Financial account that the transaction belong to.
	 */
	private Account targetAccount;
	
	/*
	 * The target User that the transaction belong to.
	 */
	private User targetUser;
	
	
	/**
	 * Creates a transaction with uninitialized variables
	 */
	public Transaction ( ) {
	}
	
	/**
	 * Creates a transaction with initialized variables
	 * @param type: type of the transaction
	 * @param isIncome: income/outcome
	 * @param amount: the amount of transaction
	 * @param targetAccount: the financial account that the transaction belongs to.
	 * @param targetUser: the user account that the transaction belongs to.
	 */
	public Transaction (String type, String description, boolean isIncome, double amount)
	{
		this.setType(type);
		this.setDescription(description); 
		this.setIsIncome(isIncome);
		this.setAmount(amount);	
		this.setRecordedTime();
		this.setTargetAccount();
		this.setTargetUser();
	}
	
	private void setDescription(String description) 
	{
		this.description = description;
		DB.update(this);
	}

	/**
	 * 
	 * @param type The type of the transaction
	 */
	public void setType(String type)
	{
		this.type = type;
		DB.update(this);
	}
	
	/**
	 * 
	 * @param type income/outcome of the transaction
	 */
	public void setIsIncome(boolean isIncome)
	{
		this.isIncome = isIncome;
		DB.update(this);
	}
	
	/**
	 * 
	 * @param amount The amount of the transaction
	 */
	public void setAmount(double amount)
	{
		this.amount = amount;
		DB.update(this);
	}
	
	/**
	 * 
	 * @param none. The recorded time of the transaction
	 */
	public void setRecordedTime()
	{
		this.recordTime = new Date();
		DB.update(this);
	}
	
	/**
	 * 
	 * @param targetAccount The target financial account of the transaction
	 */
	public void setTargetAccount()
	{
		this.targetAccount = AccountSingle.getCurrentAccount();
		DB.update(this);
	}
	
	/**
	 * 
	 * @param targetUser The target user account of the transaction
	 */
	public void setTargetUser()
	{
		this.targetUser = UserSingle.getCurrentUser();
		DB.update(this);
	}
	
	/**
	 * 
	 * @return (String) the type of the transaction
	 */
	public String getType()
	{
		return this.type;
	}
	
	/**
	 * 
	 * @return (String) the description of the transaction
	 */
	public String getDescription()
	{
		return this.description;
	}

	
	/**
	 * 
	 * @return (boolean) the income/outcome of the transaction
	 * true = income / false = outcome
	 */
	public boolean getIsIncome()
	{
		return this.isIncome;
	}
	
	/**
	 * 
	 * @return (double) the amount of the transaction
	 */
	public double getAmount()
	{
		return this.amount;
	}
	
	/**
	 * 
	 * @return (Date) the recorded time of the transaction
	 */
	public Date getRecordedTime()
	{
		return this.recordTime;
	}
	
	/**
	 * 
	 * @return (Account) the financial account of the transaction
	 */
	public Account getTargetAccount()
	{
		return this.targetAccount;
	}
	
	/**
	 * 
	 * @return (User) the user account of the transaction belongs to
	 */
	public User getTargetUser()
	{
		return this.targetUser;
	}

}
