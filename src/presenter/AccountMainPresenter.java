package presenter;

import com.example.banknote.model.Account;
import com.example.banknote.model.AccountMainHelper;

import iModel.iAccountMainModel;
import iView.iAccountMainScreen;

public class AccountMainPresenter 
{

	iAccountMainScreen view;
	iAccountMainModel model;
	
	public AccountMainPresenter(iAccountMainScreen financialAccountMain) 
	{
		view = financialAccountMain;
		model = new AccountMainHelper();
		Account acc = model.getCurrentAccount();
		
		view.setDisplayName(acc.getDisplayName());
		view.setBalance(acc.getBalance());
	}

	public void addTransClicked() 
	{
		view.gotoAddTrans();
	}
	
}
