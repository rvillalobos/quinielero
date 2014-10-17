package com.iteso.sweng.Pool;

/**
 * User: Jonas
 * Date: 12/10/2014
 * Time: 06:24 PM
 */
public class Team {

    private String name;

    public Team(String teamName)
    {
        this.name = teamName;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object teamToCompare)
    {
        if(teamToCompare != null) {
            Team team = (Team) teamToCompare;
            if (team.getName().equalsIgnoreCase(this.getName()))
            {
                return  true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return  false;
        }
    }


}
