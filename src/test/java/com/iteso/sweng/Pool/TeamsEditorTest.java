package com.iteso.sweng.Pool;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamsEditorTest {

    @Test
    public void testAddTeamToPool() throws Exception {

        // Arrange
        TeamsEditor teamsEditor = new TeamsEditor("Pool1");
        ArrayList<Team> actualListOfAddedTeams;
        ArrayList<Team> expectedListOfAddedTeams  = teamsEditor.getListOfAddedTeams();
        expectedListOfAddedTeams.add(new Team("Barcelona"));

        // Act
        teamsEditor.addTeamToPool("Barcelona");


        // Assert
        actualListOfAddedTeams = teamsEditor.getListOfAddedTeams();

        Assert.assertEquals(actualListOfAddedTeams,expectedListOfAddedTeams);
    }

    @Test
    public void testRemoveTeamFromPool() throws Exception {

        // Arrange
        TeamsEditor teamsEditorToTest = new TeamsEditor("Pool1");
        ArrayList<Team> actualListOfAddedTeams = teamsEditorToTest.getListOfAddedTeams();
        ArrayList<Team> expectedListOfAddedTeams  = teamsEditorToTest.getListOfAddedTeams();
        String teamToRemove;

        if(expectedListOfAddedTeams.size() > 0){
            Team team = expectedListOfAddedTeams.remove(0);
            teamToRemove = team.getName();

            // Act
            teamsEditorToTest.removeTeamFromPool(teamToRemove);


            // Assert
            actualListOfAddedTeams = teamsEditorToTest.getListOfAddedTeams();

            Assert.assertEquals(actualListOfAddedTeams,expectedListOfAddedTeams);
        }
    }

    @Test
    public void testSavePoolTeams() throws Exception {
        // TODO: to be implemented when db gets available
    }

    @Test
    public void testGetListOfAddedTeams_UnkownPool() throws Exception {
        // Arrange
        TeamsEditor teamsEditor = new TeamsEditor("unknownPool");
        ArrayList<Team> actualListOfAddedTeams;
        ArrayList<Team> expectedListOfAddedTeams = null;

        // Act
        actualListOfAddedTeams = teamsEditor.getListOfAddedTeams();


        // Assert
        Assert.assertEquals(actualListOfAddedTeams,expectedListOfAddedTeams);
    }

    @Test
    public void testGetListOfAvailableTeams_UnkownPool() throws Exception {
        // Arrange
        TeamsEditor teamsEditor = new TeamsEditor("unknownPool");
        ArrayList<Team> actualListOfAddedTeams;
        ArrayList<Team> expectedListOfAddedTeams = null;

        // Act
        actualListOfAddedTeams = teamsEditor.getListOfAvailableTeams();


        // Assert
        Assert.assertEquals(actualListOfAddedTeams,expectedListOfAddedTeams);
    }
}