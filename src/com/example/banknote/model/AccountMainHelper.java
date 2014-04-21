package com.example.banknote.model;

import iModel.iAccountMainModel;

public class AccountMainHelper implements iAccountMainModel 
{

	@Override
	public Account getCurrentAccount() 
	{
		return AccountSingle.getCurrentAccount();
	}
}
