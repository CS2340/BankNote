package com.example.banknote.model;

import java.util.Date;

/**
 * The Class ReportsHandler.
 */
public class ReportsHandler {

    /**
     * Adds the date from and to.
     * 
     * @param date1
     *            the date1
     * @param date2
     *            the date2
     */
    public static void addDateFromAndTo(Date date1, Date date2) {
        Reports.storeDate(date1, date2);
    }
}
