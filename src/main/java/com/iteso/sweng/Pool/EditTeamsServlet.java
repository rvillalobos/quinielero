package com.iteso.sweng.Pool;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User: Jonas
 * Date: 12/10/2014
 * Time: 11:16 AM
 */
public class EditTeamsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,
                          HttpServletResponse resp) throws javax.servlet.ServletException,
                                                           java.io.IOException
    {

        TeamsEditor teamsEditor = new TeamsEditor("Pool2");
        List<Team> listOfAvailableTeams = teamsEditor.getListOfAvailableTeams();
        List<Team> listOfAddedTeams = teamsEditor.getListOfAddedTeams();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/EditPoolTeams.jsp");

        req.setAttribute("availableTeams",listOfAvailableTeams);
        req.setAttribute("addedTeams",listOfAddedTeams);
        requestDispatcher.forward(req,resp);


    }



}
