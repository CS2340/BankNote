package presenter;

import iModel.iAddTransModel;
import iView.iAddTransView;

import java.util.List;

import com.example.banknote.model.AddTransHelper;

public class AddTransPresenter {

	iAddTransView view;
	iAddTransModel model;
	
	public AddTransPresenter(iAddTransView addTransScreen) 
	{
		view = addTransScreen;
		model = new AddTransHelper();
		List<String> incomeTypes = model.getIncomeTypes();
		List<String> expenseTypes = model.getExpenseTypes();
		view.setIncomeTypes(incomeTypes);
		view.setExpenseTypes(expenseTypes);
	}

	public void addTransClicked() 
	{
		String amount = view.getAmount();
		String description = view.getDescription();
		String type = view.getType();
		boolean isIncome = view.getIsIncome();
		if (!model.isValidDescription(description))
		{
			view.displayMessage("A transaction's description is needed.");
		}
		else if (!model.isValidAmount(amount))
		{
			view.displayMessage("That amount ain't no good.");
		}
		else
		{
			model.addNewTrans(type, description, isIncome, amount);
			view.displayMessage("Transaction added successfully");
			view.refreshInputs();
		}
	}

}

