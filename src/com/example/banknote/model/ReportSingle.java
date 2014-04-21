package com.example.banknote.model;

/**
 * The Class ReportSingle.
 */
public class ReportSingle {
	
	/** The instance. */
    private static ReportSingle instance;
    
    /** The current report. */
    private static Reports currentReport;

    /**
     * Instantiates a new user report.
     */
    private ReportSingle() {

    }

    /**
     * Instantiates a new user single.
     * 
     * @param report
     *            the report
     */
    private ReportSingle(Reports report) {
        currentReport = report;
    }

    /**
     * Gets the single instance of ReportSingle.
     * 
     * @return single instance of ReportSingle
     */
    public static ReportSingle getInstance() {
        if (instance == null) {
            instance = new ReportSingle();
        }
        return instance;
    }

    /**
     * Gets the current report.
     * 
     * @return the current report
     */
    public static Reports getCurrentReport() {
        return currentReport;
    }

    /**
     * Sets the current report.
     * 
     * @param report
     *            the new current report
     */
    public static void setCurrentReport(Reports report) {
        currentReport = report;
    }



}
