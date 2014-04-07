package com.example.banknote.model;

//import java.util.List;

//import com.db4o.ObjectContainer;
//import com.db4o.query.Predicate;

/**
 * The Class RegisterHandler.
 */
public class RegisterHandler {

    // public static boolean store(String name, String password)
    // {
    // ObjectContainer db = DBSingle.getInstance().getDB();
    //
    //
    // List<User> customers = db.query(new Predicate<User>()
    // {
    // public boolean match(User cust)
    // {
    // return cust.getName().equals("Gary");
    // }
    // });
    // User cu = customers.get(0); // get first returned Customer - should only
    // be one
    // cu.getAddress().setStreet("2 Second Street");
    // db.set(cu);
    //
    //
    //
    //
    // return true;
    // }

    /**
     * Store a name and password in database.
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     * @return true, if successful
     */
    public static boolean store(String name, String password) {
        if (isValidName(name) && isValidPassword(password)) {
            CredentialStore.add(name, password);
            return true;
        }
        return false;
    }

    /**
     * Checks if is valid name.
     * 
     * @param str
     *            the str
     * @return true, if is valid name
     */
    public static boolean isValidName(String str) {
        if (str == null || CredentialStore.containsName(str) || str.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * Checks if is valid password.
     * 
     * @param str
     *            the str
     * @return true, if is valid password
     */
    public static boolean isValidPassword(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

}
