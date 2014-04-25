package com.example.banknote.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import iModel.iReportModel;

public class TransactionsReport  implements iReportModel {
	
	/** The u. */
    private User u;
    
    /** The start. */
    private Date start;
    
    /** The end. */
    private Date end;
    
    public TransactionsReport(){
    	u = UserSingle.getCurrentUser();
    }
    
    public TransactionsReport(Date start, Date end ){
    	u = UserSingle.getCurrentUser();
    	this.start = start;
    	this.end = end;
    }

	@Override
	public void setDates(Date start, Date end) {
		// TODO Auto-generated method stub
		u = UserSingle.getCurrentUser();
        this.start = start;
        this.end = end;
	}
	
	public List<Transaction> getTransactionsByAccount() {
	    ArrayList<Transaction> allTransactions = new ArrayList<Transaction>(); 
	    if (u.getAccounts() != null) { //if there is an account 
	        List<Transaction> list = AccountSingle.getCurrentAccount().getTrans();  
	        for(Transaction t : list) {
	        	Date date = t.getRecordedTime();
	        	if (date.after(start) && date.before(end)) 
	        	{
	        		allTransactions.add(t);
	            }
	        }
	    }
	    return allTransactions; 
	}
	
	public List<Transaction> getRecentTransactionsByAccount(int number) {
	    ArrayList<Transaction> allTransactions = new ArrayList<Transaction>(); 
	    if (u.getAccounts() != null) { //if there is an account 
	        List<Transaction> list = AccountSingle.getCurrentAccount().getTrans();  
	        int i = 0;
	        for(i = 1 ; (i <= number && i <= list.size()) ; i++) {
	        	allTransactions.add(list.get(list.size()-i));
	        }
	    }
	    return allTransactions; 
	}

	@Override
	public List<ReportEntry> getOutcomeCatArrayAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportEntry> getIncomeCatArrayAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportEntry> getOutcomeCatArrayByAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReportEntry> getIncomeCatArrayByAccount(Account a) {
		// TODO Auto-generated method stub
		return null;
	}
}
