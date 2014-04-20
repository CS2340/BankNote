package com.example.banknote.model;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

/**
 * The Class CredentialStore.
 */
public class CredentialStore 
{
    
    /** The db. */
    private static ObjectContainer db;

    /**
     * Adds the.
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     */
    public static void add(String name, String password) 
    {
        User u = new User(name, password);
        DB.update(u);
    }

    /**
     * Delete a user.
     * 
     * @param u the user to be deleted
     */
    private static void delete(User u) {
        List<User> uList = getUList(u.getName());
        if (uList.size() == 0) {
            User dead = uList.get(0);
            DB.delete(dead);
        }
    }

    /**
     * Gets the user associated with the name.
     * 
     * @param name the name of the user
     * @return the user found, null if none found.
     */
    public static User getUser(final String name) {
        List<User> uList = getUList(name);
        if (uList.size() == 0) {
            return null;
        } else {
            return uList.get(0);
        }
    }

    /**
     * Determines if a user exists.
     * 
     * @param u the user
     * @return true, if successful, false if no user found.
     */
    public boolean containsUser(final User u) {
        List<User> uList = getUList(u.getName());
        return (uList.size() != 0);
    }

    /**
     * Method determines if a name is given.
     * 
     * @param name the name
     * @return true, if successful
     */
    public static boolean containsName(final String name) {
        List<User> uList = getUList(name);
        return (uList.size() != 0);

    }

    /**
     * Contains name and password.
     * 
     * @param name
     *            the name
     * @param password
     *            the password
     * @return true, if successful
     */
    public static boolean containsNameAndPassword(String name, String password) {
        if (containsName(name)) {
            return (getUser(name).getPassword().equals(password));
        } else {
            return false;
        }
    }

    /**
     * This is the only method that searches the database.
     * 
     * @param name Name of user to search
     * @return a list of any or all users with that name
     */
    private static List<User> getUList(final String name) {
        db = DB.getInstance().getDB();
        List<User> l = db.query(new Predicate<User>() {
            public boolean match(User u) {
                return name.equals(u.getName());
            }
        });
        return l;
    }

}
