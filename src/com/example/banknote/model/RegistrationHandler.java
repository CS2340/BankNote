package com.example.banknote.model;

import iModel.iRegisterModel;




/**
 * The Class RegisterPresenter.
 */
public class RegistrationHandler implements iRegisterModel
{

    /**
     * Store a name and password in database.
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     * @return true, if successful
     */
    public boolean store(String name, String password) {
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
