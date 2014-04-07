package com.example.banknote.model;

/**
 * The Class LoginHandler.
 */
public class LoginHandler {
    
    /**
     * Sets the up default credentials.
     */
    private static void setUpDefaultCredentials() {
        CredentialStore.add("admin", "pass123");
    }

    /**
     * Attempt login.
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     * @return true, if successful
     */
    public static boolean attemptLogin(String name, String password) {
        // Adds default admin account to list
        setUpDefaultCredentials();
        if (CredentialStore.containsNameAndPassword(name, password)) {
            User u = CredentialStore.getUser(name);
            UserSingle.getInstance();
            UserSingle.setCurrentUser(u);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the user.
     * 
     * @param name
     *            the name
     * @return the user
     */
    public static User getUser(String name) {
        return CredentialStore.getUser(name);
    }
}
