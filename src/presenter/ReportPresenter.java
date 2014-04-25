package presenter;

import iModel.iReportModel;
import iView.iReportView;

import java.util.ArrayList;
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
    	boolean isRadioChecked = view.getIsRadioChecked();
    	boolean isIncome = view.getIsIncome();
    	
		if (start == null || end == null) 
		{
            String message = "Must select dates";
            view.displayMessage(message);
        }  
		
		else if (!isRadioChecked)
        {
        	view.displayMessage("Check income or expense.");
        } 
		// (dates are set)
    	else if (a == null){
    		view.displayMessage("Select account to Report.");
    	} else {
    		model.setDates(start, end);
    		List<ReportEntry> list = new ArrayList<ReportEntry>();
    		if ( a.getDisplayName().equals("All Accounts")){
    			if (isIncome){
    				list = model.getIncomeCatArrayAll();
    			} else {
    				list = model.getOutcomeCatArrayAll();
    			}        		
    		} else {   			
    			if (isIncome){
    				list = model.getIncomeCatArrayByAccount(a);
    			} else {
    				list = model.getIncomeCatArrayByAccount(a);
    			}
    		}
    		view.gotoStatementReport(list);
    		
    	}
	
	}

	public void reportChartsButtonClicked() {
		// TODO Auto-generated method stub
		Date start = view.getStartDate();
    	Date end = view.getEndDate();
    	a = view.getAccount();
    	boolean isRadioChecked = view.getIsRadioChecked();
    	boolean isIncome = view.getIsIncome();
    	
		if (start == null || end == null) 
		{
            String message = "Must select dates";
            view.displayMessage(message);
        } else if (!isRadioChecked){
        	view.displayMessage("Check income or expense.");
        }
		// (dates are set)
    	else if (a == null){
    		view.displayMessage("Select account to Report.");
    	} else {
    		model.setDates(start, end);
    		List<ReportEntry> list = new ArrayList<ReportEntry>();
    		if ( a.getDisplayName().equals("All Accounts")){
    			if (isIncome){
    				list = model.getIncomeCatArrayAll();
    			} else {
    				list = model.getOutcomeCatArrayAll();
    			}        		
    		} else {   			
    			if (isIncome){
    				list = model.getIncomeCatArrayByAccount(a);
    			} else {
    				list = model.getIncomeCatArrayByAccount(a);
    			}
    		}
    		view.gotoChartReport(list);
    		
    	}
		
	}
}
