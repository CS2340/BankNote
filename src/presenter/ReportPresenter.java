package presenter;

import iModel.iReportModel;
import iView.iReportView;

import java.util.Date;
import java.util.List;

import com.example.banknote.model.Account;
import com.example.banknote.model.ReportEntry;
import com.example.banknote.model.SpendingCategoryReport;
import com.example.banknote.model.User;
import com.example.banknote.model.UserSingle;
import com.example.banknote.view.ReportActivity;

public class ReportPresenter 
{
	iReportView view;
	iReportModel model;
	
	private Account a;
	
	public ReportPresenter(ReportActivity reportActivity) 
	{
		view = reportActivity;
		model = new SpendingCategoryReport();
		
		User u = UserSingle.getCurrentUser();;
		List<Account> accounts = u.getAccounts();
		view.setAccountList(accounts);	
	}

	
	public void reportStatementButtonClicked() 
	{
		Date start = view.getStartDate();
    	Date end = view.getEndDate();
    	a = view.getAccount();
    	
		if (start == null || end == null) 
		{
            String message = "Must select dates";
            view.displayMessage(message);
        }  
		// (dates are set)
    	else if (a == null){
    		view.displayMessage("Select account to Report.");
    	} else {
    		model.setDates(start, end);
    		if ( a.getDisplayName().equals("All Accounts")){
    			List<ReportEntry> list = model.getCatArray();
        		view.gotoStatementReport(list);
    		} else {
    			List<ReportEntry> list = model.getCatArrayByAccount(a);
        		view.gotoStatementReport(list);
    		}
    		
    	}
	
	}

	public void reportChartsButtonClicked() {
		// TODO Auto-generated method stub
		Date start = view.getStartDate();
    	Date end = view.getEndDate();
    	a = view.getAccount();
    	
		if (start == null || end == null) 
		{
            String message = "Must select dates";
            view.displayMessage(message);
        }  
		// (dates are set)
    	else if (a == null){
    		view.displayMessage("Select account to Report.");
    	} else {
    		model.setDates(start, end);
    		if ( a.getDisplayName().equals("All Accounts")){
    			List<ReportEntry> list = model.getCatArray();
        		view.gotoChartReport(list);
    		} else {
    			List<ReportEntry> list = model.getCatArrayByAccount(a);
        		view.gotoChartReport(list);
    		}
    		
    	}
		
	}
}
