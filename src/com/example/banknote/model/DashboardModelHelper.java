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

	/** The list. */
    public List<ReportEntry> dataIncomeList = new ArrayList<ReportEntry>();
    public List<ReportEntry> dataOutcomeList = new ArrayList<ReportEntry>();
    
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
		int i;
		final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        
        Date startDate;
        Date endDate;
		
		
		for ( i = 0 ; i < 4 ; i++)
		{
			/*
			startDate = new Date(year, (month-i), 1);
			if (i == 0){
				endDate = new Date(year, (month-i), day);
			} else {
				endDate = new Date(year, (month-i+1), 1);
			}
			*/
			
			if ( i == 0) {
				startDate = new Date(114, 0, 1);
				endDate = new Date(114, 1, 1);
			} else if ( i == 1) {
				startDate = new Date(114, 1, 1);
				endDate = new Date(114, 2, 1);
			} else if ( i == 2) {
				startDate = new Date(114, 2, 1);
				endDate = new Date(114, 3, 1);
			} else {
				startDate = new Date(114, 3, 1);
				endDate = new Date(114, 3, 22);
			}
			
			SpendingCategoryReport helper = new SpendingCategoryReport(startDate,endDate);
			
			
			ArrayList<ReportEntry> curOutList = helper.getCatArray();
			ArrayList<ReportEntry> curInList = helper.getIncomeCatArrayAll();
			
			
			double subOutTotal = curOutList.get(curOutList.size()-1).getAmount();

			
			ReportEntry curOut = new ReportEntry (startDate.toString());
			curOut.addToAmount(subOutTotal);
			
			dataOutcomeList.add(curOut);
			
			double subInTotal = curInList.get(curInList.size()-1).getAmount();
			
			ReportEntry curIn = new ReportEntry (startDate.toString());
			curIn.addToAmount(subInTotal);
			
			dataOutcomeList.add(curIn);
			
			
		}
	}
	
	public List<ReportEntry> getchartOutcomeList(){
		return dataOutcomeList;
	}
	
	public List<ReportEntry> getchartIncomeList(){
		return dataIncomeList;
	}
	
	
	
}
