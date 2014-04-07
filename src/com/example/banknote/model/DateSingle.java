package com.example.banknote.model;

import java.util.Date;

/**
 * The Class DateSingle.
 */
public class DateSingle {
    
    /** The start date. */
    private Date startDate;
    
    /** The end date. */
    private Date endDate;
    
    /** The selected date. */
    private Date selectedDate;

    /**
     * Instantiates a new date single.
     */
    private DateSingle() {
    }

    /**
     * The Class SingletonHolder.
     */
    private static class SingletonHolder {
        
        /** The Constant INSTANCE. */
        private static final DateSingle INSTANCE = new DateSingle();
    }

    /**
     * Gets the single instance of DateSingle.
     * 
     * @return single instance of DateSingle
     */
    public static DateSingle getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * Gets the start date.
     * 
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the selectedt date.
     * 
     * @param date
     *            the new selectedt date
     */
    public void setSelectedtDate(Date date) {
        if (selectedDate == startDate) {
            startDate = date;
        }
        if (selectedDate == endDate) {
            endDate = date;
        }

    }

    /**
     * Gets the end date.
     * 
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Checks if is end date.
     * 
     * @return true, if is end date
     */
    public boolean isEndDate() {
        return (selectedDate == endDate);
    }

    /**
     * Select start date.
     */
    public void selectStartDate() {
        startDate = selectedDate;
    }

    /**
     * Select end date.
     */
    public void selectEndDate() {
        endDate = selectedDate;
    }
}