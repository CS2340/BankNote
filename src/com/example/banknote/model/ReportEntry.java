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
        String s1 = "      " + String.format("%-40s ",category);
        String s2 = String.format(" $%9.2f",amount);
        String s = s1 + s2;
        return s;
    }

}
