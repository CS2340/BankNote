package com.example.banknote.model;

import iModel.iReportModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * The Class SpendingCategoryReport.
 */
public class SpendingCategoryReport implements iReportModel {
    
    /** The u. */
    private User u;
    
    /** The start. */
    private Date start;
    
    /** The end. */
    private Date end;
    
    /** The entries. */
    ArrayList<ReportEntry> entries;
    
    /** The total. */
    ReportEntry total;

    /**
     * Instantiates a new spending category report.
     * 
     * @param aStart the start
     * @param anEnd the end
     */
    public SpendingCategoryReport(Date aStart, Date anEnd) {
        u = UserSingle.getCurrentUser();
        this.start = aStart;
        this.end = anEnd;
        entries = new ArrayList<ReportEntry>();
        total = new ReportEntry("Total");

    }

    public SpendingCategoryReport() 
    {
		// TODO Auto-generated constructor stub
	}

	/**
     * Gets the OUTCOME cat array ALL ACCOUNTS
     * 
     * @return the cat array
     */
    public ArrayList<ReportEntry> getCatArray() {
        if (u.getAccounts() != null) {
            for (Account a : u.getAccounts()) {
                ArrayList<Transaction> trans = (ArrayList<Transaction>) a
                        .getTrans();
                {
                    for (Transaction t : trans) {
                        if (!t.getIsIncome()) {
                            Date date = t.getRecordedTime();
                            if (date.after(start) && date.before(end)) {
                                updateEntries(t);
                            }
                        }
                    }
                }
            }
        }
        
        entries.add(entries.size(), total);
        return entries;
    }
    
    /**
     * Gets the INCOME cat array ALL ACCOUNTS
     * 
     * @return the cat array
     */
    public ArrayList<ReportEntry> getIncomeCatArrayAll() {
        if (u.getAccounts() != null) {
            for (Account a : u.getAccounts()) {
                ArrayList<Transaction> trans = (ArrayList<Transaction>) a
                        .getTrans();
                {
                    for (Transaction t : trans) {
                        if (t.getIsIncome()) {
                            Date date = t.getRecordedTime();
                            if (date.after(start) && date.before(end)) {
                                updateEntries(t);
                            }
                        }
                    }
                }
            }
        }
        entries.add(entries.size(), total);
        return entries;
    }
    

	/**
     * Gets the cat array by account
     * 
     * @return the cat array
     */
    public ArrayList<ReportEntry> getCatArrayByAccount(Account a) {
        if (u.getAccounts() != null) {
        	for (Account cur : u.getAccounts()) {
        		if ( cur.getDisplayName().equals(a.getDisplayName())){
                	ArrayList<Transaction> trans = (ArrayList<Transaction>) cur
                            .getTrans();
                    
                    for (Transaction t : trans){
                    	if (!t.getIsIncome()) {
                    		Date date = t.getRecordedTime();
                    		if (date.after(start) && date.before(end)) 
                    		{
                    			updateEntries(t);
                            }
                        }
                    }
        		}
        	}  
               
        }
        entries.add(entries.size(), total);
        return entries;
    }
    
    /**
     * Gets the INCOME cat array by SELECTED ACCOUNT.
     * 
     * @return the cat array
     */
    public ArrayList<ReportEntry> getIncomeCatArrayByAccount(Account a) {
        if (u.getAccounts() != null) {
        	for (Account cur : u.getAccounts()) {
        		if ( cur.getDisplayName().equals(a.getDisplayName())){
                	ArrayList<Transaction> trans = (ArrayList<Transaction>) cur
                            .getTrans();
                    
                    for (Transaction t : trans){
                    	if (t.getIsIncome()) {
                    		Date date = t.getRecordedTime();
                    		if (date.after(start) && date.before(end)) 
                    		{
                    			updateEntries(t);
                            }
                        }
                    }
        		}
        	}  
               
        }
        entries.add(entries.size(), total);
        return entries;
    }
        

    /**
     * Update entries.
     * 
     * @param t the transaction
     */
    private void updateEntries(Transaction t) {
        boolean found = false;
        for (ReportEntry entry : entries) {
            if (entry.getCategory().equals(t.getType())) {
                entry.addToAmount(-t.getAmount()); // negative is important
                found = true;
            }
        }
        if (!found) {
            ReportEntry newEntry = new ReportEntry(t.getType());
            if (t.getAmount() < 0 ){
            	newEntry.addToAmount(-t.getAmount()); // negative is important
            } else {
            	newEntry.addToAmount(t.getAmount());
            }
            entries.add(newEntry);
        }
        if (t.getAmount() < 0 ){
        	total.addToAmount(-t.getAmount()); // negative is important
        } else {
        	total.addToAmount(t.getAmount());
        }
    }

	@Override
	public void setDates(Date aStart, Date anEnd) 
	{
        u = UserSingle.getCurrentUser();
        this.start = aStart;
        this.end = anEnd;
        entries = new ArrayList<ReportEntry>();
        total = new ReportEntry("Total");
        entries.add(total);
	}

}
