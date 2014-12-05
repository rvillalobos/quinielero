package com.iteso.sweng.Login;

import com.iteso.sweng.Pool.LeavePool;
import com.iteso.sweng.Pool.MyObjects;
import com.iteso.sweng.Pool.SelectPoolMode;

import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * User: Jonas
 * Date: 04/10/2014
 * Time: 09:50 AM
 */
public class LoginServlet extends HttpServlet {

    /**
     * Entry point for the Log in page
     * @param req
     * @param resp
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp) throws javax.servlet.ServletException,
                                                          java.io.IOException
    {
        try
        {
            // Extract user log in data
            String unsecureUserName = req.getParameter("username");
            String unsercurePassword = req.getParameter("password");

            resp.setContentType("text/html");
            // Allocate a output writer to write the response message into the network socket
            PrintWriter out = resp.getWriter();



            LoginVerificator loginVerificator = new LoginVerificator();

            switch (loginVerificator.checkUserAndPassword(unsecureUserName,
                                                          unsercurePassword))
            {
                case VALID_USER_AND_PASSWORD:
                    // Write the response message, in an HTML page
                    try {


                       // LeavePool lp = new LeavePool();
                        // lp.DeleteUserFromPool("sebas","pool_10");

                        MyObjects o = new MyObjects();

                       ArrayList<String> teams= o.getMyTeams("Mauricio");
                        ArrayList<String> leagues=  o.getMyLeagues("Mauricio");

                        SelectPoolMode sp = new SelectPoolMode();

                        sp.SelectPoolMode(2,"Pool_10","Mauricio");



                        out.println("<html>");
                        out.println("<head><title>Valid user and password</title></head>");
                        out.println("<body>");

                        out.println("<p>My teams</p><br>");
                        for (String team: teams){
                            out.println("<br>"+team);
                        }

                        out.println("<p>My Leagues</p><br>");
                        for (String league: leagues){
                            out.println("<br>"+league);
                        }
                        out.println("<br>"+sp.frase);

                        out.println("<h1> Dummy page </h1>");
                        // Echo client's request information
                        out.println("<p>Welcome, " + unsecureUserName + "</p>");


                        out.println("<p>Verification Number: <strong>" + Math.random() + "</strong></p>");

                        out.println("</body></html>");




                    } finally {
                        out.close();  // Always close the output writer
                    }
                    break;

                case WRONG_PASSWORD:
                    try {
                        out.println("<html>");
                        out.println("<head><title>Wrong Password</title></head>");
                        out.println("<body>");
                        out.println("<h1> Dummy page </h1>");
                        // Echo client's request information
                        out.println("<p>The password did not match </p>");
                        out.println("<p>Verification Number: <strong>" + Math.random() + "</strong></p>");
                        out.println("</body></html>");
                    } finally {
                        out.close();  // Always close the output writer
                    }
                    break;

                case UNKNOWN_USER:
                    try {
                        out.println("<html>");
                        out.println("<head><title>Unknown User</title></head>");
                        out.println("<body>");
                        out.println("<h1> Dummy page </h1>");
                        // Echo client's request information
                        out.println("<p>Unknown user </p>");
                        out.println("<p>Verification Number: <strong>" + Math.random() + "</strong></p>");
                        out.println("</body></html>");
                    } finally {
                        out.close();  // Always close the output writer
                    }
                    break;

                default:
                    break;
            }



/*
            // Set the response MIME type of the response message
                resp.setContentType("text/html");
                // Allocate a output writer to write the response message into the network socket
                PrintWriter out = resp.getWriter();

                // Write the response message, in an HTML page
                try {
                    out.println("<html>");
                    out.println("<head><title>Hello, World</title></head>");
                    out.println("<body>");
                    out.println("<h1> Debugg page </h1>");
                    // Echo client's request information
                    out.println("<p>User: " + sUserName + "</p>");
                    out.println("<p>Password: " + sPassword + "</p>");
                    out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
                    out.println("</body></html>");
                } finally {
                    out.close();  // Always close the output writer
                }
*/
            /*
            UserInfo user = new UserInfo();
            user.setUserName(req.getParameter("un"));
            user.setPassword(req.getParameter("pw"));

            //user = UserDAO.login(user);

            if (user.isValid())
            {
                HttpSession session = req.getSession(true);
                session.setAttribute("currentSessionUser",user);
                resp.sendRedirect("userLogged.jsp"); //logged-in page
            }
            else
                resp.sendRedirect("invalidLogin.jsp"); //error page
            */
        }
        catch (Throwable theException)
        {
            System.out.println(theException);
        }
    }
}
