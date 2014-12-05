package com.iteso.sweng.Login;

import org.omg.CORBA.ORBPackage.InvalidName;
import java.sql.*;


/**
 * User: Jonas
 * Date: 03/12/2014
 * Time: 07:15 PM
 */
public class QueryHandlerMySQL extends QueryHandler {
    @Override
    public boolean isUserRegistered(String userName) {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            java.sql.Driver d  = new com.mysql.jdbc.Driver();
            //Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                                                                DatabaseConnectionUser,
                                                                DatabaseConnectionPassword);
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT Name FROM quinielero.ProfileData WHERE Name = " + "'"+ userName +"'");

            boolean result;
            // Go to the last element, and check if the results was emtpy
            resultSet.last();
            if(resultSet.getRow() > 0){
                // User has been found
                result = true;
            }
            else{
                // User NOT found
                result = false;
            }

            stmt.close();
            connection.close();

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DBC Connection Failed");
            return false;
        }

        /*finally {
            // Something went wrong with the DB connection
            // TODO: Notify user that the DB Connection could not be completed
            return false;
        }*/
    }

    @Override
    public String getUserPassword(String userName) throws InvalidName {

        if(isUserRegistered(userName) == true){
            // SELECT UserPassword FROM quinielero.Users where UserName = 'Jonas'
            try {

                Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                                                                    DatabaseConnectionUser,
                                                                    DatabaseConnectionPassword);
                Statement stmt = connection.createStatement();

                ResultSet resultSet = stmt.executeQuery("SELECT UserPassword FROM quinielero.Users where UserName = "+ "'"+ userName +"'");


                // TODO: Implement security validations (i.e. empty string, empty query etc)
                String userPassword;
                resultSet.next();
                userPassword = resultSet.getString("UserPassword");

                stmt.close();
                connection.close();

                return userPassword;

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("DBC Connection Failed");
                return  null;
            }
            /*
            finally {
                // Something went wrong with the DB connection
                // TODO: Notify user that the DB Connection could not be completed
                return null;
            }
            */
        }
        else{
            // Invalid user, or at least was not found in the DB
            throw new InvalidName("Hey! user name " + userName + "was not found in the DB");
        }
    }

    @Override
    public boolean getEmailNotificationConfiguration(String userName) {
        if(isUserRegistered(userName) == true){
            try {

                Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                                                                    DatabaseConnectionUser,
                                                                    DatabaseConnectionPassword);
                Statement stmt = connection.createStatement();

                ResultSet resultSet = stmt.executeQuery("SELECT PD_boReceiveEmail " +
                                                        "FROM quinielero.ProfileData " +
                                                        "WHERE Name = " + "'"+ userName +"'");

                // TODO: Implement security validations
                boolean emailNogificationFlag;
                resultSet.next();
                emailNogificationFlag = resultSet.getBoolean("PD_boReceiveEmail");

                stmt.close();
                connection.close();

                return emailNogificationFlag;


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("DBC Connection Failed");
                return false;
            }
            /*
            finally {
                // Something went wrong with the DB connection
                // TODO: Notify user that the DB Connection could not be completed
                return false;
            }
            */
        }
        else{
            // Invalid user, or at least was not found in the DB
            return false;
        }
    }

    @Override
    public void removeEmailNotifications(String userName) {
        if(isUserRegistered(userName) == true){
            try {

                Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                                                                    DatabaseConnectionUser,
                                                                    DatabaseConnectionPassword);
                Statement stmt = connection.createStatement();

                stmt.executeUpdate("UPDATE quinielero.ProfileData " +
                                   "SET PD_boReceiveEmail = '0' " +
                                   "WHERE ProfileData.Name = " + "'"+ userName +"'");

                stmt.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("DBC Connection Failed");
            }
        }
        else{
            // TODO: Invalid user, or at least was not found in the DB
        }
    }

    @Override
    public void activeEmailNotifications(String userName) {
        if(isUserRegistered(userName) == true){
            try {

                Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                        DatabaseConnectionUser,
                        DatabaseConnectionPassword);
                Statement stmt = connection.createStatement();

                stmt.executeUpdate("UPDATE quinielero.ProfileData " +
                        "SET PD_boReceiveEmail = '1' " +
                        "WHERE ProfileData.Name = " + "'"+ userName +"'");

                stmt.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("DBC Connection Failed");
            }
        }
        else{
            // TODO: Invalid user, or at least was not found in the DB
        }
    }

    @Override
    public String getUserEmail(String userName) throws InvalidName {
        if(isUserRegistered(userName) == true){
            // SELECT UserPassword FROM quinielero.Users where UserName = 'Jonas'
            try {

                Connection connection = DriverManager.getConnection(DatabaseConectionPath,
                                                                    DatabaseConnectionUser,
                                                                    DatabaseConnectionPassword);
                Statement stmt = connection.createStatement();

                ResultSet resultSet = stmt.executeQuery("SELECT UserEmail " +
                                                        "FROM quinielero.Users " +
                                                        "WHERE UserName = " + "'"+ userName +"'");
                // TODO: Implement security validations (i.e. empty string, empty query etc)
                String userEmail;
                resultSet.next();
                userEmail = resultSet.getString("UserEmail");

                stmt.close();
                connection.close();

                return userEmail;


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("DBC Connection Failed");
                return  null;
            }
            /*
            finally {
                // Something went wrong with the DB connection
                // TODO: Notify user that the DB Connection could not be completed
                return null;
            }
            */
        }
        else{
            // Invalid user, or at least was not found in the DB
            throw new InvalidName("Hey! user name " + userName + "was not found in the DB");
        }
    }

    @Override
    public UsersBean getUserProfileInformation(String userName) {
        return null;
    }
}
