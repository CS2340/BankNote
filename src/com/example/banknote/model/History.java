package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.Toast;

/**
 * History class contain the list of transactions associate with financial account or a user account.
 * @author Nghia Huynh
 *
 */

public class History {
	
	/*
	 * ArrayList of transaction
	 */
	private List<Transaction> transList;
	
	public History (){
		transList = new ArrayList<Transaction>();
	}
	
	
	/**
	 * Adds new transaction in the the Transaction List in the History
	 * @param newTrans: the new transaction added to the list.
	 */
	public void addNewTrans (Transaction newTrans) {
		// add newTrans to the Transaction List
		transList.add(newTrans);
		DB.update(this);
	}
	
	/**
	 * when account created, adds first transaction in the List as Initial Balance
	 */
	public void setIntBalacce (double amount) {
		Transaction initialTransaction = new Transaction ("Initial Balance", "Initial Balance", true, amount);
		transList.add(initialTransaction);
		DB.update(this);
	}
	
	
	public Transaction getLastTransaction(){
		int numOfTrans = transList.size();
		return transList.get(numOfTrans - 1);
	}
	
	public List<Transaction> getArrayList() {
		return transList; 
	}
	
	
}
