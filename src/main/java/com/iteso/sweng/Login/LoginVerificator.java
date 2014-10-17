package com.iteso.sweng.Login;

import org.omg.CORBA.ORBPackage.InvalidName;

/**
 * User: John
 * Date: 04/10/2014
 * Time: 02:00 PM
 */
public class LoginVerificator {

    public  enum LoginResults{
        VALID_USER_AND_PASSWORD,
        UNKNOWN_USER,
        WRONG_PASSWORD
    };

    /**
     * Checks in the Database if a given user and password combination is present
     * in the registers.
     * @param userName The user name to be checked
     * @param userPassword The password to be checked
     * @return Either VALID_USER_AND_PASSWORD, UNKNOWN_USER or WRONG_PASSWORD
     */
    public LoginResults checkUserAndPassword(String userName,
                                             String userPassword)
    {
        // TODO: QueryHandlerDummy should be replaced by the real QueryHandler when the database is ready
        QueryHandler queryHandler = new QueryHandlerDummy();

        // Safety first...
        // TODO: SQL injection security may be required to be implemented here
        if(userName == null)
            return LoginResults.UNKNOWN_USER;
        if(userPassword == null)
            return  LoginResults.WRONG_PASSWORD;

        // Go and check the user information
        if(queryHandler.isUserRegistered(userName)){

            try {
                String realUserPassword = queryHandler.getUserPassword(userName);
                if(realUserPassword.equalsIgnoreCase(userPassword)) {

                    return LoginResults.VALID_USER_AND_PASSWORD;
                }
                else {
                    return  LoginResults.WRONG_PASSWORD;
                }
            }
            catch (InvalidName e)
            {
                return LoginResults.UNKNOWN_USER;
            }
        }
        else {
            // The user is not present in the database
            return LoginResults.UNKNOWN_USER;
        }
    }
}
