package iModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.banknote.model.Account;
import com.example.banknote.model.ReportEntry;

public interface iReportModel 
{

	void setDates(Date start, Date end);

	List<ReportEntry> getOutcomeCatArrayAll();
	List<ReportEntry> getIncomeCatArrayAll();
	List<ReportEntry> getOutcomeCatArrayByAccount(Account a);
	List<ReportEntry> getIncomeCatArrayByAccount(Account a);

}
