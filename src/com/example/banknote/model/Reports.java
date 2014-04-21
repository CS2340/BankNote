package com.example.banknote.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class of the model to generate Reports.
 */
public class Reports {

    /** The Constant SHOPPING. */
    private static final String SHOPPING = "Shopping";
    
    /** The Constant FOOD_AND_DRINK. */
    private static final String FOOD_AND_DRINK = "Food and Drink";
    
    /** The Constant BILLS. */
    private static final String BILLS = "Bills";
    
    /** The Constant ENTERTAINMENT. */
    private static final String ENTERTAINMENT = "Entertainment";
    
    /** The Constant FAMILY_AND_PERSONAL. */
    private static final String FAMILY_AND_PERSONAL = "Family and Personal";
    
    /** The Constant HOME. */
    private static final String HOME = "Home";
    
    /** The Constant UTILITIES. */
    private static final String UTILITIES = "Utilities";
    
    /** The Constant TRAVEL. */
    private static final String TRAVEL = "Travel";
    
    /** The Constant OTHERS. */
    private static final String OTHERS = "Others";
    
    /** The Constant CAR. */
    private static final String CAR = "Car";

    /** The food and drink. */
    public static List<Transaction> foodAndDrink;
    
    /** The shopping. */
    public static List<Transaction> shopping;
    
    /** The bills. */
    public static List<Transaction> bills;
    
    /** The entertainment. */
    public static List<Transaction> entertainment;
    
    /** The family and personal. */
    public static List<Transaction> familyAndPersonal;
    
    /** The home. */
    public static List<Transaction> home;
    
    /** The utilities. */
    public static List<Transaction> utilities;
    
    /** The car. */
    public static List<Transaction> car;
    
    /** The travel. */
    public static List<Transaction> travel;
    
    /** The others. */
    public static List<Transaction> others;

    /** The date from. */
    static Date dateFrom;
    
    /** The date to. */
    static Date dateTo;
    
    /** The report list and dates for Charts and Statement. */
    private List<ReportEntry> list;
    private Date fromDate;
    private Date toDate;

    /**
     * Store date.
     * 
     * @param date1
     *            the date1
     * @param date2
     *            the date2
     */
    public static void storeDate(Date date1, Date date2) {
        dateFrom = date1;
        dateTo = date2;
    }

    /**
     * Gets the date range.
     * 
     * @param fullList
     *            the full list
     * @return the date range
     */
    public static List<Transaction> getDateRange(List<Transaction> fullList) {
        List<Transaction> dateRange = new ArrayList<Transaction>();
        for (Transaction t : fullList) {
            if (t.getRecordedTime().after(dateFrom)
                    && t.getRecordedTime().before(dateTo)) {
                dateRange.add(t);
            }
        }
        
        return dateRange;
    }

    /**
     * Gets the full list.
     * 
     * @return the full list
     */
    public static List<Transaction> getFullList() {
        // get list of accounts
        ArrayList<Account> accounts = UserSingle.getCurrentUser().getAccounts();
        // actual list of transactions for each account
        List<Transaction> fullList = null;
        // gets list of all the histories of each account
        for (int i = 0; i < accounts.size(); i++) {
            Account current = accounts.get(i);
            // gets arraylist transactions
            fullList.addAll(current.getHistory().getArrayList());
        }
        // now i got a full list of all the transactions, sort them
        return fullList;
    }

    /**
     * Spending category report.
     * 
     * @param dateRange the date range
     * @return the list of strings for the report to display
     */
    public static ArrayList<String> spendingCategoryReport(
            List<Transaction> dateRange) {
        ArrayList<String> report = new ArrayList<String>();
        Transaction currTransanction;
        for (int i = 0; i < dateRange.size(); i++) {
            currTransanction = dateRange.get(i);
            String currType = currTransanction.getType();
            if (currType.equals(FOOD_AND_DRINK)) {
                foodAndDrink.add(currTransanction);
            } else if (currType.equals(SHOPPING)) {
                shopping.add(currTransanction);
            } else if (currType.equals(BILLS)) {
                bills.add(currTransanction);

            } else if (currType.equals(ENTERTAINMENT)) {
                entertainment.add(currTransanction);

            } else if (currType.equals(FAMILY_AND_PERSONAL)) {
                familyAndPersonal.add(currTransanction);

            } else if (currType.equals(HOME)) {
                home.add(currTransanction);

            } else if (currType.equals(UTILITIES)) {
                utilities.add(currTransanction);

            } else if (currType.equals(CAR)) {
                car.add(currTransanction);

            } else if (currType.equals(TRAVEL)) {
                travel.add(currTransanction);

            } else if (currType.equals(OTHERS)) {
                others.add(currTransanction);
            }
        }
        
        report.add(getFoodAndDrinkTotal());
        report.add(getShoppingTotal());
        report.add(getBillsTotal());
        report.add(getEntertainmentTotal());
        report.add(getFamilyAndPersonalTotal());
        report.add(getHomeTotal());
        report.add(getUtilitiesTotal());
        report.add(getCarTotal());
        report.add(getTravelTotal());
        report.add(getOthersTotal());
        
        return report;
    }
    

    /**
     * Gets the food and drink total.
     * @return the food and drink total
     */
    public static String getFoodAndDrinkTotal() {
        double sum = 0;
        for (int i = 0; i < foodAndDrink.size(); i++) {
            Transaction curr = foodAndDrink.get(i);
            sum = sum + curr.getAmount();
        }
        return FOOD_AND_DRINK + Double.toString(sum);
    }

    /**
     * Gets the shopping total.
     * @return the shopping total
     */
    public static String getShoppingTotal() {
        double sum = 0;
        for (int i = 0; i < shopping.size(); i++) {
            Transaction curr = shopping.get(i);
            sum = sum + curr.getAmount();
        }
        return SHOPPING + Double.toString(sum);
    }

    /**
     * Gets the bills total.
     * @return the bills total
     */
    public static String getBillsTotal() {
        double sum = 0;
        for (int i = 0; i < bills.size(); i++) {
            Transaction curr = bills.get(i);
            sum = sum + curr.getAmount();
        }
        return BILLS + Double.toString(sum);
    }

    /**
     * Gets the entertainment total.
     * @return the entertainment total
     */
    public static String getEntertainmentTotal() {
        double sum = 0;
        for (int i = 0; i < entertainment.size(); i++) {
            Transaction curr = entertainment.get(i);
            sum = sum + curr.getAmount();
        }
        return ENTERTAINMENT + Double.toString(sum);
    }

    /**
     * Gets the family and personal total.
     * @return the family and personal total
     */
    public static String getFamilyAndPersonalTotal() {
        double sum = 0;
        for (int i = 0; i < familyAndPersonal.size(); i++) {
            Transaction curr = familyAndPersonal.get(i);
            sum = sum + curr.getAmount();
        }
        return FAMILY_AND_PERSONAL + Double.toString(sum);
    }

    /**
     * Gets the home total.
     * @return the home total
     */
    public static String getHomeTotal() {
        double sum = 0;
        for (int i = 0; i < home.size(); i++) {
            Transaction curr = home.get(i);
            sum = sum + curr.getAmount();
        }
        return HOME + Double.toString(sum);
    }

    /**
     * Gets the utilities total.
     * @return the utilities total
     */
    public static String getUtilitiesTotal() {
        double sum = 0;
        for (int i = 0; i < utilities.size(); i++) {
            Transaction curr = utilities.get(i);
            sum = sum + curr.getAmount();
        }
        return UTILITIES + Double.toString(sum);
    }

    /**
     * Gets the car total.
     * @return the car total
     */
    public static String getCarTotal() {
        double sum = 0;
        for (int i = 0; i < car.size(); i++) {
            Transaction curr = car.get(i);
            sum = sum + curr.getAmount();
        }
        return CAR + Double.toString(sum);
    }

    /**
     * Gets the travel total.
     * @return the travel total
     */
    public static String getTravelTotal() {
        double sum = 0;
        for (int i = 0; i < travel.size(); i++) {
            Transaction curr = travel.get(i);
            sum = sum + curr.getAmount();
        }
        return TRAVEL + Double.toString(sum);
    }

    /**
     * Gets the others total.
     * @return the others total
     */
    public static String getOthersTotal() {
        double sum = 0;
        for (int i = 0; i < others.size(); i++) {
            Transaction curr = others.get(i);
            sum = sum + curr.getAmount();
        }
        return OTHERS + Double.toString(sum);
    }

    // getters

    /**
     * Gets the food and drink.
     * @return the food and drink
     */
    public static List<Transaction> getFoodAndDrink() {
        return foodAndDrink;
    }

    /**
     * Gets the shopping.
     * @return the shopping
     */
    public static List<Transaction> getShopping() {
        return shopping;
    }

    /**
     * Gets the bills.
     * @return the bills
     */
    public static List<Transaction> getBills() {
        return bills;
    }

    /**
     * Gets the entertainment.
     * @return the entertainment
     */
    public static List<Transaction> getEntertainment() {
        return entertainment;
    }

    /**
     * Gets the family and personal.
     * @return the family and personal
     */
    public static List<Transaction> getFamilyAndPersonal() {
        return familyAndPersonal;
    }

    /**
     * Gets the home.
     * @return the home
     */
    public static List<Transaction> getHome() {
        return home;
    }

    /**
     * Gets the utilities.
     * @return the utilities
     */
    public static List<Transaction> getUtilities() {
        return utilities;
    }

    /**
     * Gets the car.
     * @return the car
     */
    public static List<Transaction> getCar() {
        return car;
    }

    /**
     * Gets the travel.
     * @return the travel
     */
    public static List<Transaction> getTravel() {
        return travel;
    }

    /**
     * Gets the others.
     * @return the others
     */
    public static List<Transaction> getOthers() {
        return others;
    }

    /**
     * Gets the reports.
     * 
     * @param start
     *            the start
     * @param end
     *            the end
     * @return the reports
     */
    public static ArrayList<String> getReports(Date start, Date end) {
        storeDate(start, end);
        return spendingCategoryReport(getDateRange(getFullList()));

    }
    
    /**
     * Initialize Reports object.
     * USE FOR CHART AND STATEMENT REPORT
     */
    public Reports(Date from, Date to, List<ReportEntry> list)
    {
    	this.fromDate = from;
    	this.toDate = to;
    	this.list = list;
    }
    
    /**
     * Set a list to the user's report list.
     * USE FOR CHART AND STATEMENT REPORT    !!! DO NOT DELETE, It's not a duplicate function
     */
    public void setReportList(List<ReportEntry> list) {
        this.list = list;
    }
    
    /**
     * Returns the list of the user's report list.
     * USE FOR CHART AND STATEMENT REPORT    !!! DO NOT DELETE, It's not a duplicate function
     * @return the list of accounts
     */
    public List<ReportEntry> getReportList() {
        return this.list;
    }

    /**
     * Returns the start date of the user's report list.
     * USE FOR CHART AND STATEMENT REPORT    !!! DO NOT DELETE, It's not a duplicate function
     * @return the list of accounts
     */
    public Date getFromDate() {
        return this.fromDate;
    }
    
    /**
     * Returns the end date of the user's report list.
     * USE FOR CHART AND STATEMENT REPORT    !!! DO NOT DELETE, It's not a duplicate function
     * @return the list of accounts
     */
    public Date getToDate() {
        return this.toDate;
    }
}
