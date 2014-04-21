package presenter;

import iModel.iLoginModel;
import iView.iLoginScreen;

import com.example.banknote.model.LoginHandler;

public class LoginPresenter 
{

	iLoginScreen view;
	iLoginModel model;
	
	public LoginPresenter(iLoginScreen loginScreen) 
	{
		view = loginScreen;
		model = new LoginHandler();
	}

	public void loginClicked() 
	{
		String name = view.getName();
		String password = view.getPassword();
		boolean success = model.attemptLogin(name,password);
		if (success)
		{
			view.gotoDashboardScreen();
		}
		else
		{
			view.displayMessage("Try Again");
		}
	}
}
