package presenter;

import iModel.iAddFinAccountModel;
import iView.iAddFinAccountScreen;

import com.example.banknote.model.AddAccountHandler;

public class AddAccountPresenter 
{
	iAddFinAccountScreen view;
	iAddFinAccountModel model;
	
	public AddAccountPresenter(iAddFinAccountScreen addFinAccount) 
	{
		view = addFinAccount;
		model = new AddAccountHandler();
	}
	
	public void addAccountClicked()
	{
		String fullName = view.getFullName();
		String displayName = view.getDisplayName();
		String balance = view.getBalance();
		String rate = view.getRate();
		
        if (!model.isValidName(fullName)) 
        {
            view.displayMessage("Invalid Full Name");
        }

        else if (model.nameAlreadyExists(fullName, displayName)) 
        {
            view.displayMessage("Account with that name already exists.");
        }

        else if (!model.isValidInterestRate(rate)) 
        {
            view.displayMessage("Invalid Interest Rate");
        }
        else if (!model.isValidAmount(balance)) 
        {
            view.displayMessage("Please input the valid amount!");
        } 
        else // good job
        {
            model.addAccount(fullName, displayName, balance,
                    rate);
            view.displayMessage("Account created.");
            view.gotoFinAccMain();

        }

	}
}
