package com.iteso.sweng.Pool;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * User: Jonas
 * Date: 13/10/2014
 * Time: 11:20 PM
 */
public class SaveTeamsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws javax.servlet.ServletException,
            java.io.IOException {

        resp.setContentType("text/html");
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = resp.getWriter();

        try {
            out.println("<html>");
            out.println("<head><title>Valid user and password</title></head>");
            out.println("<body>");
            out.println("<h1> Dummy page </h1>");
            // Echo client's request information
            out.println("<p> Changes saved </p>");
            out.println("<p>Verification Number: <strong>" + Math.random() + "</strong></p>");
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
        }

    }
}
