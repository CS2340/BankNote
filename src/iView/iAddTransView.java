package iView;

import java.util.List;

public interface iAddTransView {

	void setIncomeTypes(List<String> incomeTypes);

	void setExpenseTypes(List<String> expenseTypes);

	String getAmount();

	String getDescription();

	String getType();

	boolean getIsIncome();

	void displayMessage(String string);

	void refreshInputs();

}
