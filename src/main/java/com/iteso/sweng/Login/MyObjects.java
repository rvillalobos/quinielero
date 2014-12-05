package com.iteso.sweng.Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Mauricio Landeros on 05/12/2014.
 */
public class MyObjects {

    public ArrayList<String> getMyTeams(String username){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/quinielero", "quinielero2014", "quinielero");
            Statement stmt = con.createStatement();
            ArrayList<String> teams= new ArrayList<String>();
            ResultSet rs = stmt.executeQuery("Select TeamName from UsersTeam where UserName='" + username + "';");
            while(rs.next())
                teams.add(rs.getString(1));
            System.out.println("\n\n\n\n\n\n\n ------------- "+rs.last());
            return teams;
        }
        catch (Exception e){
            System.out.println("\n\n\n\n\n\n\n error ------------- ");
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    public ArrayList<String> getMyLeagues(String username){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/quinielero", "quinielero2014", "quinielero");
            Statement stmt = con.createStatement();
            ArrayList<String> league= new ArrayList<String>();
            ResultSet rs = stmt.executeQuery("Select l.Name from UsersLeague U, League l where U.IdLeague=l.IdLeague and   UserName='" + username + "';");
            while(rs.next())
                league.add(rs.getString(1));
            return league;
        }
        catch (Exception e){
        }
        return new ArrayList<String>();
    }




}
