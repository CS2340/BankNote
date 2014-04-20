package com.example.banknote.model;

import iModel.iDashboardModel;

public class DashboardModelHelper implements iDashboardModel 
{

	@Override
	public User getUser() 
	{
		return UserSingle.getCurrentUser();
	}

	@Override
	public void setAccount(Account a) 
	{
		AccountSingle.setCurrentAccount(a);	
	}
	
}
