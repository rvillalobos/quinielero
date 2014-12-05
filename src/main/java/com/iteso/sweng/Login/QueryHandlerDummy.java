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
	private HashMap <String,UsersBean> listOfUsers;
	
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
		
		listOfUsers = new HashMap <String,UsersBean>();
		UsersBean r = new UsersBean();
		UsersBean l = new UsersBean();
		UsersBean s = new UsersBean();
	
		r.setUserName("Rodrigo");
		r.setLastName("Villalobos");
		r.setBirthday("9/Enero");
		r.setCity("Guadalajara");
		r.setCountry("Mexico");
		r.setEmail("rodrigo@soft.com");
		r.setFavoriteTeam("Morelia");
		r.setPhoto("profile.jpg");
		
		l.setUserName("Luis");
		l.setLastName("Villalobos");
		l.setBirthday("10/Enero");
		l.setCity("Guadalajara");
		l.setCountry("Mexico");
		l.setEmail("luis@soft.com");
		l.setFavoriteTeam("Pachuca");
		l.setPhoto("profile.jpg");
		
		s.setUserName("Santiago");
		s.setLastName("Villalobos");
		s.setBirthday("9/Febrero");
		s.setCity("Guadalajara");
		s.setCountry("Mexico");
		s.setEmail("santiago@soft.com");
		s.setFavoriteTeam("Santos");
		s.setPhoto("profile.jpg");
		
		listOfUsers.put("Rodrigo",r);
		listOfUsers.put("Luis",l);
		listOfUsers.put("Santiago",s);
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
			throw new InvalidName("User name does not exist");
		}
	}
	
	public UsersBean getUserProfileInformation(String userName){
		if(listOfUsers.containsKey(userName)){
			return listOfUsers.get(userName);
		}
		return null;
	}


    public boolean getEmailNotificationConfiguration(String userName){
        return true;
    }

    @Override
    public void removeEmailNotifications(String userName) {
        /* Do nothing */
    }

    @Override
    public void activeEmailNotifications(String userName) {
        /* Do nothing */
    }

}
