package com.iteso.sweng.Pool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Jonas
 * Date: 12/10/2014
 * Time: 11:16 AM
 */
public abstract class PoolQueryHandler {

    public abstract boolean poolExists(String poolName);

    /**
     * Places a query to the database and retrieves all the team's names
     * stored in the database.
     * @return The list of teams stored in the database, null if no team found.
     */
    public abstract ArrayList<Team> getAvailableTeams();

    /**
     * Places a query to the database and retrieves all the teams included
     * in a given pool.
     * @param poolsName The target pool to extract teams
     * @return The list of teams included in the target pool
     */

    public abstract ArrayList<Team> getPoolsTeams(String poolsName);

    /**
     * Places a query to the database and stores a list of teams into the specified
     * pool.
     * @param poolsName The target pool to write
     * @param teamsToSave The list of teams to store into the database
     */
    public abstract void savePoolsTeams(String poolsName,ArrayList<Team> teamsToSave);



}
