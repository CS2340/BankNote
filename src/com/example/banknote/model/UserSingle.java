package com.example.banknote.model;

/**
 * The Class UserSingle.
 */
public class UserSingle {

    /** The instance. */
    private static UserSingle instance;
    
    /** The current user. */
    private static User currentUser;

    /**
     * Instantiates a new user single.
     */
    private UserSingle() {

    }

    /**
     * Instantiates a new user single.
     * 
     * @param user
     *            the user
     */
    private UserSingle(User user) {
        currentUser = user;
    }

    /**
     * Gets the single instance of UserSingle.
     * 
     * @return single instance of UserSingle
     */
    public static UserSingle getInstance() {
        if (instance == null) {
            instance = new UserSingle();
        }
        return instance;
    }

    /**
     * Gets the current user.
     * 
     * @return the current user
     */
    public static User getCurrentUser() {
        return currentUser;
    }

    /**
     * Sets the current user.
     * 
     * @param user
     *            the new current user
     */
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

}
