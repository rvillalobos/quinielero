package com.iteso.sweng.Login;
import org.omg.CORBA.ORBPackage.InvalidName;

import java.util.HashMap;

/**
 * User: Jonas
 * Date: 04/10/2014
 * Time: 02:25 PM
 */
public class QueryHandlerDummy extends QueryHandler{

	private HashMap<String,String> listOfDummyUsers;

	public QueryHandlerDummy()
	{
		listOfDummyUsers = new HashMap<String, String>();
		// Loading hardcoded users
		//                    UserName, Password
		listOfDummyUsers.put("Rodrigo","Rodrigo");
		listOfDummyUsers.put("Luis","Luis");
		listOfDummyUsers.put("Ramiro","Ramiro");
		listOfDummyUsers.put("Santiago","Santiago");
		listOfDummyUsers.put("Sebastian","Sebastian");
		listOfDummyUsers.put("Jonas","Jonas");
		listOfDummyUsers.put("Mauricio","Mauricio");
		listOfDummyUsers.put("Alejandro","Alejandro");
		listOfDummyUsers.put("Roy","Roy");
	}

	public boolean isUserRegistered(String userName)
	{
		if(listOfDummyUsers.containsKey(userName))
		{
			return  true;
		}
		else
		{
			return false;
		}

	}

	public String getUserEmail(String userName)
	{
		String user = null;
		if(listOfDummyUsers.containsKey(userName))
		{ 
			user = listOfDummyUsers.get(userName);
		}
		return user + "@soft.com";
	}

	public String getUserPassword(String userName) throws InvalidName
	{
		if(isUserRegistered(userName))
		{
			// Return password
			return listOfDummyUsers.get(userName);
		}
		else
		{
			// Return Exception
			throw new InvalidName("User name does not exists");
		}
	}


}
