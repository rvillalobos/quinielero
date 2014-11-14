package com.iteso.sweng.Pool;

import java.sql.*;

/**
 * Created by Mauricio Landeros on 12/11/2014.
 */
public class LeavePool {

    public void DeleteUserFromPool(String user, String pool) {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/quinielero","quinielero2014","quinielero");
            Statement stmt = con.createStatement();

            stmt.executeUpdate("delete from PoolParticipants where username='"+user+"' and poolname='"+pool+"';");
            //ResultSet rs = stmt.executeQuery("SELECT * FROM PoolParticipants");

            stmt.close();
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("holi");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void setLimitUser(int num, String pool){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/quinielero","quinielero2014","quinielero");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update Pools SET PoolMinNumber='"+num+"' where poolname='"+pool+"';");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

