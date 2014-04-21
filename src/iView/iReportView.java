package iView;

import java.util.Date;
import java.util.List;

import com.example.banknote.model.Account;
import com.example.banknote.model.ReportEntry;

public interface iReportView {

	Date getStartDate();

	Date getEndDate();
	
	Account getAccount();
	
	void onBackPressed();
	
	void setAccountList(List<Account> accounts) ;

	void displayMessage(String message);
	
	void gotoChartReport(List<ReportEntry> list);
	
	void gotoStatementReport(List<ReportEntry> list);

}
