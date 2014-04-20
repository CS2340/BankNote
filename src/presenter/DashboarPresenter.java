package presenter;

import iModel.iDashboardModel;
import iView.iDashboardActivity;

import java.util.List;

import com.example.banknote.model.Account;
import com.example.banknote.model.DashboardModelHelper;
import com.example.banknote.model.User;

public class DashboarPresenter 
{

	private iDashboardActivity view;
	private iDashboardModel model;
	private Account a;
	
	public DashboarPresenter(iDashboardActivity dashboard) 
	{
		view = dashboard;
		model = new DashboardModelHelper();
		User u = model.getUser();
		List<Account> accounts = u.getAccounts();
		view.setAccountList(accounts);	
	}

	public void viewAccountsClicked() 
	{
		a = view.getAccount();
		if (a == null)
		{
			view.displayMessage("No accounts to view.");
		}
		else
		{
			model.setAccount(a);
			view.gotoViewAccounts();
		}
	}

	public void createAccountClicked() 
	{
		view.gotoCreateAccount();
	}

	public void reportClicked() 
	{
		view.gotoReports();		
	}
}
