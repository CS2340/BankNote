package presenter;

import iModel.iWelcomeModel;
import iView.iWelcomeScreen;

import com.example.banknote.model.WelcomeModel;

public class WelcomePresenter
{

	iWelcomeScreen view;
	iWelcomeModel model;
	
	public WelcomePresenter(iWelcomeScreen welcomeScreen) 
	{
		view = welcomeScreen;
		String path = view.getFilePath();
		model = new WelcomeModel();
		model.setUpDB(path);
	}

	public void loginClicked() 
	{
		view.gotoLogin();
	}

	public void registerClicked() 
	{
		view.gotoRegister();
	}
	
}
