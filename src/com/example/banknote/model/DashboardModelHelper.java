package com.example.banknote.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	
	
	public void getChartDataList(){
		User u = UserSingle.getCurrentUser();
		List<ReportEntry> list = new ArrayList<ReportEntry>();
		for (Account a : u.getAccounts()){
			ReportEntry curr = new ReportEntry(a.getDisplayName());
			curr.addToAmount(a.getBalance());
			list.add(curr);
		}
		Reports report = new Reports(new Date(), new Date(), list);
		ReportSingle.setCurrentReport(report); 
		//ReportSingle.getCurrentReport().setReportList(list);
	
	}
	
}
