package presenter;

import iModel.iRegisterModel;
import iView.iRegisterScreen;

import com.example.banknote.model.RegistrationHandler;

public class RegisterPresenter 
{
	String message = "Try again";
	iRegisterModel model;
	iRegisterScreen view;
	public RegisterPresenter(iRegisterScreen registerScreen) 
	{
		view = registerScreen;
		model = new RegistrationHandler();
	}

	public void registerClicked() 
	{
		String name = view.getName();
		String p1 = view.getPass1();
		String p2 = view.getPass2();
		
        if (p1.equals(p2) && model.store(name, p1)) 
        {
            view.gotoLogin();
        }
        else
        {
        	view.displayMessage(message);
        }
	}

}
