package com.example.banknote.model;

import java.util.ArrayList;
import java.util.Date;

public class SpendingCategoryReport {
	private User u;
	private Date start;
	private Date end;
	ArrayList<ReportEntry> entries;
	ReportEntry total;
	
	
	public SpendingCategoryReport(Date start, Date end) 
	{
		u = UserSingle.getCurrentUser();
		this.start= start;
		this.end = end;
		entries = new ArrayList<ReportEntry>();
		total = new ReportEntry("Total");
		entries.add(total);
		
	}

	public ArrayList<ReportEntry> getCatArray() 
	{
		if (u.getAccounts() != null)
		{
			for (Account a: u.getAccounts())
			{
//				if (a.getHistory() != null)
//				{
//					History h = a.getHistory();
//					if (h.getArrayList() != null)
//					{
						ArrayList<Transaction> trans =  (ArrayList<Transaction>) a.getTrans();
						{
							for(Transaction t : trans)
							{
								if (!t.getIsIncome())
								{
									Date date = t.getRecordedTime();
									if (date.after(start) && date.before(end))
									{
										updateEntries(t);
									}
								}
							}
//						}
//					}
						
				}
			}
		}
		return entries;
	}
	

	private void updateEntries(Transaction t) 
	{
		boolean found = false;
		for (ReportEntry entry: entries)
		{
			if (entry.getCategory().equals(t.getType()))
			{
				entry.addToAmount(-t.getAmount());//negative is important
				found = true;
			}
		}
		if (!found)
		{
			ReportEntry newEntry = new ReportEntry(t.getType());
			newEntry.addToAmount(-t.getAmount());//negative is important
			entries.add(newEntry);
		}
		total.addToAmount(-t.getAmount()); //negative is important
	}
	

	

}
