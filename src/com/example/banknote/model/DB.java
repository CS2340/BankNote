package com.example.banknote.model;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.AndroidSupport;
import com.db4o.config.EmbeddedConfiguration;
/**
 * Uses Singleton Pattern
 * @author jacksonkmillsaps
 *
 */
public class DB
{
	private static ObjectContainer db;

	
	private DB(){};
	
	
	private static class Holder 
	{
		private static final DB INSTANCE = new DB();
	}
	
	public static DB getInstance() 
	{
		return Holder.INSTANCE;
	}
	
	public void setDB(String filePath)
	{
		if (db == null)
		{
			final EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		    config.common().add(new AndroidSupport());
		    config.common().objectClass(User.class).cascadeOnUpdate(true);
		    config.common().objectClass(User.class).cascadeOnDelete(true);
		    config.common().objectClass(Account.class).cascadeOnUpdate(true);
		    config.common().objectClass(Account.class).cascadeOnDelete(true);
		    config.common().objectClass(History.class).cascadeOnUpdate(true);
		    config.common().objectClass(History.class).cascadeOnDelete(true);
		    config.common().objectClass(Transaction.class).cascadeOnUpdate(true);
		    config.common().objectClass(Transaction.class).cascadeOnDelete(true);
		    config.common().objectClass(User.class).objectField("name").indexed(true);  
		    db = Db4oEmbedded.openFile(config,filePath);
		}
	}
	

	public ObjectContainer getDB()
	{
		return db;
	}
	
	
	
	public static <T> void update(T t)
	{
		db.store(t);
		db.commit();
	}

	public static <T> void delete(T p) 
	{
		db.delete(p);
		db.commit();
	}
	

}
	
	
    
	
	
