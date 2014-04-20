package com.example.banknote.model;

import iModel.iAddTransModel;

import java.util.Arrays;
import java.util.List;

public class AddTransHelper implements iAddTransModel 
{
	private String[] expenseTypes = 
		{ 	
			"Food and Drink",
			"Shopping",
			"Bills",
			"Entertainment",
			"Family and Personal",
			"Home",
			"Utilities",
			"Car",
			"Travel",
			"Bribes",
			"Other"
		};
	
	private String[] incomeTypes =
		{
			"Business",
			"Salary",
			"Extra Income",
			"Gifts",
			"Bribes",
			"Other"
		};


	@Override
	public List<String> getIncomeTypes() 
	{
		return Arrays.asList(incomeTypes);
	}


	@Override
	public List<String> getExpenseTypes() 
	{
		return Arrays.asList(expenseTypes);
	}


	@Override
	public boolean isValidDescription(String d) 
	{
		return !(d == null || d.equals(""));
	}


	@Override
	public void addNewTrans(String type, String description, boolean isIncome,
			String amount) 
	{
	    double transAmount = Double.parseDouble(amount);

	    // Negative amount for outcome transaction
	    if (!isIncome) {
	        transAmount = (-1) * transAmount;
	    }

	    // create new transaction by defined instructors

	    Transaction newTrans = new Transaction(type, description, isIncome,
	            transAmount);
	    AccountSingle.getCurrentAccount().addNewTrans(newTrans);

	    // Update the Balance in current account
	    AccountSingle.getCurrentAccount().updateBalance(transAmount);
	}


	@Override
	public boolean isValidAmount(String amount) 
	{
	    if (amount == null || amount.equals("")) {
	        return false;
	    }

	    return (amount.matches("[0-9]*\\.[0-9]{2}") || amount
	            .matches("[0-9]*"));
	}

}

