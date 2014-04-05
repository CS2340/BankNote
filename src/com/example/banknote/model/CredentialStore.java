package com.example.banknote.model;


import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;

public class CredentialStore 
{
	private static ObjectContainer db;
	
	public static void add(String name, String password)
	{
		User u = new User(name, password);
		DB.update(u);
	}
	
	private static void delete(User u)
	{
		List<User> uList = getUList(u.getName());
		if (uList.size() == 0)
		{
			User dead = uList.get(0);
			DB.delete(dead);
		}
	}
	
	public static User getUser(final String name)
	{
		List<User> uList = getUList(name);
		if (uList.size() == 0)
		{
			return null;
		}
		else return uList.get(0);
	}
	
	
	public boolean containsUser(final User u)
	{
		List<User> uList = getUList(u.getName());
		return (uList.size() != 0);
	}

	
	public static boolean containsName(final String name)
	{
		List<User> uList = getUList(name);
		return (uList.size() != 0);
		
	}


	public static boolean containsNameAndPassword(String name, String password) 
	{
		if (containsName(name))
		{
			return (getUser(name).getPassword().equals(password));
		}
		else return false;
	}
	
	
	/**
	 * This is the only method that searches the database.
	 * 
	 * @param name
	 * @return a list of any or all users with that name
	 */
	private static List<User> getUList(final String name) 
	{
		db = DB.getInstance().getDB();
		List<User> l = db.query(new Predicate<User>() 
			    {
		        	public boolean match(User u) 
		        	{
		        		return name.equals(u.getName());
		        	}
		        });
		return l;
	}
	
	
}
