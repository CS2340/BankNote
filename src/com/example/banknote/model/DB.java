package com.example.banknote.model;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.AndroidSupport;
import com.db4o.config.EmbeddedConfiguration;


/**
 * Uses Singleton Pattern.
 * 
 * @author jacksonkmillsaps
 * 
 */
public class DB {

    /** The db. */
    private static ObjectContainer db;

    /**
     * Instantiates a new db.
     */
    private DB() {
    };

    /**
     * The Class Holder.
     */
    private static class Holder {

        /** The Constant INSTANCE. */
        private static final DB INSTANCE = new DB();
    }

    /**
     * Gets the single instance of DB.
     * 
     * @return single instance of DB
     */
    public static DB getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * Sets the db.
     * 
     * @param filePath
     *            the new db
     */
    public void setDB(String filePath) {
        if (db == null) {
            final EmbeddedConfiguration config = Db4oEmbedded
                    .newConfiguration();
            config.common().add(new AndroidSupport());
            config.common().objectClass(User.class).cascadeOnUpdate(true);
            config.common().objectClass(User.class).cascadeOnDelete(true);
            config.common().objectClass(Account.class).cascadeOnUpdate(true);
            config.common().objectClass(Account.class).cascadeOnDelete(true);
            config.common().objectClass(History.class).cascadeOnUpdate(true);
            config.common().objectClass(History.class).cascadeOnDelete(true);
            config.common().objectClass(Transaction.class)
                    .cascadeOnUpdate(true);
            config.common().objectClass(Transaction.class)
                    .cascadeOnDelete(true);
            config.common().objectClass(User.class).objectField("name")
                    .indexed(true);
            db = Db4oEmbedded.openFile(config, filePath);
        }
    }

    /**
     * Gets the db.
     * 
     * @return the db
     */
    public ObjectContainer getDB() {
        return db;
    }

    /**
     * Update.
     * 
     * @param <T>
     *            the generic type
     * @param t
     *            the t
     */
    public static <T> void update(T t) {
        db.store(t);
        db.commit();
    }

    /**
     * Delete.
     * 
     * @param <T>
     *            the generic type
     * @param p
     *            the p
     */
    public static <T> void delete(T p) {
        db.delete(p);
        db.commit();
    }

}
