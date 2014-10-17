package com.iteso.sweng.Login;

import org.omg.CORBA.ORBPackage.InvalidName;

/**
 * User: Jonas
 * Date: 04/10/2014
 * Time: 01:46 PM
 */
public abstract class QueryHandler {

    /**
     * Places a query to the database and determines whether a given user
     * is already registered in the system.
     * @param userName The user name to be checked
     * @return true if the user is present in the database, otherwise false
     */
    public abstract boolean isUserRegistered(String userName);

    /**
     * Retrieves the password of a registered user. Warning, user verification
     * should be performed before calling this method.
     * Throws InvalidName if user name is not present in the database.
     * @param userName The user name to extract password
     * @return Password raw in a simple string
     */
    public abstract String getUserPassword(String userName) throws InvalidName;
    
    public abstract String getUserEmail(String userName) throws InvalidName;

}
