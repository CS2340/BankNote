package com.example.banknote.model;

import java.io.Serializable;



/**
 * Simulates a financial account
 * @author jacksonkmillsaps
 *
 */

public class Account implements Comparable<Account>, Serializable
{
	/*
	 * A descriptive name for the account
	 */
	private String fullName;
	/*
	 * The name that will be displayed (should be optional and default to full name)
	 */
	private String displayName;
	/*
	 * current account balance
	 */
	private double balance;
	
	/*
	 * Annual interest rate (optional, should default to 0)
	 */
	private double interestRate;

	
	/*
	 * A History object that store transaction information. 
	 * @Editted by Nghia Huynh
	 */
	private History transHistory = new History();
	
	/**
	 * 
	 * @param fullName A descriptive name for the account
	 * @param displayName The name that will be displayed (should be optional and default to full name)
	 * @param balance initial balance
	 * @param interestRate Annual interest rate (optional, should default to 0)
	 */
	public Account(String fullName, String displayName, double balance, double interestRate)
	{
		setFullName(fullName);
		setDisplayName(displayName);
		setBalance(balance);
		setInterestRate(interestRate);
	}
	
	/**
	 * Creates an account with uninitialized variables
	 */
	public Account() 
	{

	}

	/**
	 * 
	 * @param fullName A descriptive name for the account
	 */
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
		//since display name is optional, it defaults to full name if not yet set
		if (displayName == null)
		{
			displayName = fullName;
		}
	}
	
	/**
	 * 
	 * @param displayName The name that will be displayed
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}
	
	/**
	 * 
	 * @param balance the amount to set balance to
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	/**
	 * 
	 * @param interesetRate anual interest rate
	 */
	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	
	/**
	 * 
	 * @return the full name of the account
	 */
	public String getFullName()
	{
		return fullName;
	}
	
	/**
	 * 
	 * @return the display name for the account
	 */
	public String getDisplayName()
	{
		return displayName;
	}
	
	/**
	 * 
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * 
	 * @return the interest rate
	 */
	public double getInterestRate()
	{
		return interestRate;
	}
	
	/**
	 * 
	 * @return the History
	 */
	public History getHistory()
	{
		return transHistory;
	}
	
	/**
	 * Update account's balance with the last recent transaction added
	 */
	public void updateBalance(double amount){
		balance += amount;
	}
	
	
	/**
	 * Compares the balance of this account to another
	 * @param other the Account to which we are comparing
	 * @return 0 if equal, positive if this balance is bigger, negative if other balance is bigger
	 */
	public int compareTo(Account other)
	{
		Double difference = balance - other.getBalance();
		return difference.compareTo(0.0);
	}
}
