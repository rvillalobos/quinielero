package com.iteso.sweng.Profile;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import com.iteso.sweng.Login.QueryHandlerDummy;
import com.iteso.sweng.Login.UsersBean;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersBean u;
	public UsersBean getUsersBean() {
		return u;
	}

	public void setUsersBean(UsersBean u) {
		this.u = u;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserProfileServlet() {
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
		String userName = request.getParameter("userName");
		RequestDispatcher dispatcher=null;
		
		setUsersBean(new QueryHandlerDummy().getUserProfileInformation(userName));
		
		HttpSession session = request.getSession( );
		session.setAttribute("userInformation", getUsersBean());
		dispatcher = getServletContext().getRequestDispatcher( "/profilePage.jsp" );
		dispatcher.forward( request, response);

	}

}
