package com.iteso.sweng.Pool;

import com.sun.jndi.ldap.pool.Pool;

import java.util.ArrayList;

/**
 * User: Jonas
 * Date: 12/10/2014
 * Time: 11:17 AM
 */
public class PoolQueryHandlerDummy extends PoolQueryHandler {


    public boolean poolExists(String poolName)
    {
        // Safety first
        if(poolName == null){
            return false;
        }
        // Only two pools are defined;
        // Pool1
        // Pool2
        if(poolName.equalsIgnoreCase("Pool1") ||
           poolName.equalsIgnoreCase("Pool2"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList<Team> getAvailableTeams() {
        ArrayList<Team> listOfDummyTeams = new ArrayList<Team>();

        // Loading hardcoded teams
        listOfDummyTeams.add(new Team("America"));
        listOfDummyTeams.add(new Team("Atlas"));
        listOfDummyTeams.add(new Team("Chiapas"));
        listOfDummyTeams.add(new Team("Cruz Azul"));
        listOfDummyTeams.add(new Team("Guadalajara"));
        listOfDummyTeams.add(new Team("Leon"));
        listOfDummyTeams.add(new Team("Monterrey"));
        listOfDummyTeams.add(new Team("Morelia"));
        listOfDummyTeams.add(new Team("Pachuca"));
        listOfDummyTeams.add(new Team("Puebla"));
        listOfDummyTeams.add(new Team("Queretaro"));
        listOfDummyTeams.add(new Team("Santos"));
        listOfDummyTeams.add(new Team("Tijuana"));
        listOfDummyTeams.add(new Team("Toluca"));
        listOfDummyTeams.add(new Team("UANL"));
        listOfDummyTeams.add(new Team("U. de G."));
        listOfDummyTeams.add(new Team("UNAM"));
        listOfDummyTeams.add(new Team("Veracruz"));

        return  listOfDummyTeams;
    }

    public ArrayList<Team> getPoolsTeams(String poolsName){
        // Only two pools are defined;
        // Pool1
        // Pool2
        if(poolsName.equalsIgnoreCase("Pool1"))
        {
            ArrayList<Team> listOfDummyTeams = new ArrayList<Team>();

            listOfDummyTeams.add(new Team("America"));
            listOfDummyTeams.add(new Team("Atlas"));
            listOfDummyTeams.add(new Team("Chiapas"));
            listOfDummyTeams.add(new Team("Cruz Azul"));
            listOfDummyTeams.add(new Team("Guadalajara"));
            listOfDummyTeams.add(new Team("Leon"));
            listOfDummyTeams.add(new Team("Monterrey"));
            listOfDummyTeams.add(new Team("Morelia"));
            listOfDummyTeams.add(new Team("Pachuca"));

            return listOfDummyTeams;
        }
        else if(poolsName.equalsIgnoreCase("Pool2"))
        {
            ArrayList<Team> listOfDummyTeams = new ArrayList<Team>();

            listOfDummyTeams.add(new Team("Pachuca"));
            listOfDummyTeams.add(new Team("Puebla"));
            listOfDummyTeams.add(new Team("Queretaro"));
            listOfDummyTeams.add(new Team("Santos"));
            listOfDummyTeams.add(new Team("Tijuana"));
            listOfDummyTeams.add(new Team("Toluca"));
            listOfDummyTeams.add(new Team("UANL"));
            listOfDummyTeams.add(new Team("U. de G."));
            listOfDummyTeams.add(new Team("UNAM"));
            listOfDummyTeams.add(new Team("Veracruz"));

            return listOfDummyTeams;
        }
        else
        {
            // Pool not found, return null
            return  null;
        }
    }

    public void savePoolsTeams(String poolsName,ArrayList<Team> teamsToSave){
        // TODO: Do nothing
    }

}
