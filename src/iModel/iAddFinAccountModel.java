package iModel;

public interface iAddFinAccountModel {

	boolean isValidName(String fullName);

	boolean nameAlreadyExists(String fullName, String displayName);

	boolean isValidInterestRate(String rate);

	boolean isValidAmount(String balance);

	void addAccount(String fullName, String displayName, String balance,
			String rate);

	

}
