package com.iteso.sweng.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.ORBPackage.InvalidName;


/**
 * Servlet implementation class validateUserAndEmailServlet
 */
@WebServlet("/validateUserAndEmailServlet")
public class validateUserAndEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public validateUserAndEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter( "userName" );
		String eMail = request.getParameter( "eMail" );
		QueryHandler queryHandler = new QueryHandlerDummy();
		String nextPage = "";
		
		try {
			if(queryHandler.getUserEmail(userName).equals(eMail)){
				nextPage = "/restorePassword.jsp";
			}
			else{
				nextPage = "/incorrectValidate.jsp";
			}
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		RequestDispatcher dispatcher = getServletContext().
				getRequestDispatcher( nextPage );
		System.out.println(dispatcher );
		dispatcher.forward( request, response);
			
		}
	

}
