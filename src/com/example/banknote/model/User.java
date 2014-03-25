package com.example.banknote.model;

import java.util.ArrayList;

/**
 *  Synonymous with "User Account" each has a name and password.
 * @author jacksonkmillsaps
 * 
 */
public class User 
{
	
	private String name;
	private String password;
	private ArrayList<Account> accounts;

	/*
	 * ArrayList of transaction 
	 */
	private ArrayList<Transaction> transactionList;
	
	
	/**
	 * Creates a new user with a name and password
	 * @param name 
	 * @param password
	 */
	public User(String name, String password) 
	{
		this.name = name;
		this.password = password;
		this.accounts = new ArrayList<Account>();
	}

	/**
	 * Creates a new user with null string name and password
	 */
	public User() 
	{
		name = "";
		password = "";
		this.accounts = new ArrayList<Account>();
	}

	/**
	 * gets the name of the user
	 * @return the name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * gets the password of the user
	 * @return the password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * Sets the name of the user
	 * @param name 
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * Sets the password of the user
	 * @param password
	 */
	public void setPassword(String password)
	{
		this.password = password;		
	}

	/**
	 * Adds a new account to the users accounts
	 * @param account
	 */
	public void addAccount(Account account)
	{
		this.accounts.add(account);
	}
	
	/**
	 * Returns a list of the user's accounts
	 * @return the list of accounts
	 */
	public ArrayList<Account> getAccounts()
	{
		return accounts;
	}
}
