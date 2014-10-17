package com.iteso.sweng.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class verifyPasswordServlet
 */
@WebServlet("/verifyPasswordServlet")
public class verifyPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public verifyPasswordServlet() {
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
		String newPassword = request.getParameter( "newPassword" );
		String verifyPassword = request.getParameter( "verifyPassword" );
		String nextPage = "";
		/**
		 * The password will be encrypted by the MD5 algorithm, when the DB be ready
		 */ 
		if(newPassword.equals(verifyPassword))
			nextPage = "/inside.jsp";
		else
			nextPage = "/dontMatchPassword.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher( nextPage );
		dispatcher.forward( request, response);		
	}

}
