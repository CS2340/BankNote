package iModel;

import java.util.List;

public interface iAddTransModel 
{

	List<String> getIncomeTypes();

	List<String> getExpenseTypes();

	boolean isValidDescription(String description);

	void addNewTrans(String type, String description, boolean isIncome,
			String amount);

	boolean isValidAmount(String amount);

}
