package com.example.banknote.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportEntry.
 */
public class ReportEntry {
    
    /** The category. */
    String category;
    
    /** The amount. */
    double amount;

    /**
     * Instantiates a new report entry.
     * 
     * @param aCategory the category
     */
    public ReportEntry(String aCategory) {
        this.category = aCategory;
        this.amount = 0;
    }

    /**
     * Gets the category.
     * 
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Gets the amount.
     * 
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Adds the to amount.
     * 
     * @param addition
     *            the addition
     */
    public void addToAmount(double addition) {
        amount += addition;
    }

    /**
     * toString for the account class.
     * 
     * @return String of the account class.
     */
    public String toString() {
        String s = new String(category + "      " + Double.toString(amount));
        return s;
    }

}
