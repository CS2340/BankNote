package com.example.banknote.model;


/**
 * The Class AddTransactionHandler.
 */
public class AddTransactionHandler {

    /**
     * Adds the new trans.
     * 
     * @param type
     *            the type
     * @param description
     *            the description
     * @param isIncome
     *            the is income
     * @param amount
     *            the amount
     */
    public static void addNewTrans(String type, String description,
            boolean isIncome, String amount) {

        double transAmount = Double.parseDouble(amount);

        // Negative amount for outcome transaction
        if (!isIncome) {
            transAmount = (-1) * transAmount;
        }

        // create new transaction by defined instructors

        Transaction newTrans = new Transaction(type, description, isIncome,
                transAmount);
        AccountSingle.getCurrentAccount().addNewTrans(newTrans);

        // Update the Balance in current account
        AccountSingle.getCurrentAccount().updateBalance(transAmount);
    }

    /**
     * Checks if is valid description.
     * 
     * @param name
     *            the name
     * @return true, if is valid description
     */
    public static boolean isValidDescription(String name) {
        return !(name == null || name.equals(""));
    }

    /**
     * Checks if is valid amount.
     * 
     * @param transAmount
     *            the trans amount
     * @return true, if is valid amount
     */
    public static boolean isValidAmount(String transAmount) {
        if (transAmount == null || transAmount.equals("")) {
            return false;
        }

        return (transAmount.matches("[0-9]*\\.[0-9]{2}") || transAmount
                .matches("[0-9]*"));
    }

}
