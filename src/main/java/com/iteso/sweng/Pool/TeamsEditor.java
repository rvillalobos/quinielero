package com.iteso.sweng.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jonas
 * Date: 12/10/2014
 * Time: 11:16 AM
 */
public class TeamsEditor {

    private ArrayList<Team> listOfAddedTeams;
    private ArrayList<Team> listOfAvailableTeams;
    private String poolToEdit;

    public TeamsEditor(String poolToEdit)
    {
        // TODO: PoolQueryHandlerDummy should be replaced by the real PoolQueryHandler when the database is ready
        PoolQueryHandler poolQueryHandler = new PoolQueryHandlerDummy();

        if(poolQueryHandler.poolExists(poolToEdit))
        {
            this.poolToEdit = poolToEdit;
            // Load list with data from database
            listOfAddedTeams = poolQueryHandler.getPoolsTeams(poolToEdit);
            listOfAvailableTeams = poolQueryHandler.getAvailableTeams();

            // remove repeated teams from available
            for(int i = 0; i < listOfAvailableTeams.size(); i++)
            {
                String tempAvailableTeam = listOfAvailableTeams.get(i).getName();
                for(int j = 0; j < listOfAddedTeams.size(); j++)
                {
                    String tempAddedTeam = listOfAddedTeams.get(j).getName();

                    if(tempAddedTeam.equalsIgnoreCase(tempAvailableTeam))
                    {
                        listOfAvailableTeams.remove(i);
                        // Element has been removed, go and check remaining element
                        i--;
                    }
                }
            }
        }
        else
        {
            // Pool invalid, don't load any data
            listOfAvailableTeams = null;
            listOfAddedTeams = null;
        }
    }

    public void addTeamToPool(String teamToAdd)
    {
        // Safety first
        if(teamToAdd == null) {
            return;
        }
        // Add team to "Added Teams" list
        listOfAddedTeams.add(new Team(teamToAdd));

        // Remove Team from "Available Teams" list
        for(int i = 0; i < listOfAvailableTeams.size(); i++){
            if(listOfAvailableTeams.get(i).getName().equalsIgnoreCase(teamToAdd))
            {
                listOfAvailableTeams.remove(i);
                return;
            }
        }
    }

    public void removeTeamFromPool(String teamToRemove)
    {
        if(teamToRemove == null) {
            return;
        }

        // Add team to "Available Teams" list
        listOfAvailableTeams.add(new Team(teamToRemove));

        // Remove team from "Added Teams" list
        for(int i = 0; i < listOfAddedTeams.size(); i++) {
            if (listOfAddedTeams.get(i).getName().equalsIgnoreCase(teamToRemove)) {
                listOfAddedTeams.remove(i);
                return;
            }
        }
    }

    public void savePoolTeams()
    {
        // TODO: PoolQueryHandlerDummy should be replaced by the real PoolQueryHandler when the database is ready
        PoolQueryHandler poolQueryHandler = new PoolQueryHandlerDummy();

        if(poolQueryHandler.poolExists(this.poolToEdit))
        {
            poolQueryHandler.savePoolsTeams(this.poolToEdit,this.listOfAddedTeams);
        }
        else
        {
            // TODO: Handle unknown pool
        }
    }


    /**
     * Retrieves the current Added Teams list
     * @return Deep copy of Added Teams
     */
    public ArrayList<Team> getListOfAddedTeams()
    {
        if(this.listOfAddedTeams != null) {
            return (ArrayList<Team>)this.listOfAddedTeams.clone();
        }
        else{
            return  null;
        }


    }

    /**
     * Retrieves the current Available Teams list
     * @return Deep copy of Available Teams
     */
    public ArrayList<Team> getListOfAvailableTeams()
    {
        if(this.listOfAvailableTeams != null){
            return (ArrayList<Team>)this.listOfAvailableTeams.clone();
        }
        else {
            return  null;
        }

    }



}
