package com.iteso.sweng.Pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Mauricio Landeros on 05/12/2014.
 */
public class SelectPoolMode {

     public int flag=0;
    public String frase;

    public void SelectPoolMode(int num,String pool, String username) {
        try {



            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/quinielero", "quinielero2014", "quinielero");
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("Select * from Pools where poolname='" + pool + "' and UserName='" + username + "';");

            int rsCount = 0;

//but notice that you'll only get correct ResultSet size after end of the while loop
            while(rs.next())
            {
                //do your other per row stuff
                rsCount = rsCount + 1;
                if(rs.getInt(2)==1)
                    frase="Nombre: "+rs.getString(1)+" Tipo Match";
                else
                    frase="Nombre: "+rs.getString(1)+" Tipo Round";

            }//end while

            if(rsCount != 0){
                stmt.executeQuery("update Pools SET PoolMode='"+num+"' where poolname='"+pool+"';");
            }

            flag=1;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}