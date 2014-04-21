package iView;

import java.util.List;

import com.example.banknote.model.Account;
import com.example.banknote.model.User;

public interface iDashboardActivity 
{


	void setAccountList(List<Account> accounts);

	Account getAccount();

	void gotoViewAccounts();

	void displayMessage(String string);

	void gotoCreateAccount();

	void gotoReports();

}
