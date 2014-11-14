package com.iteso.sweng.Profile;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteso.sweng.Login.QueryHandlerDummy;
import com.iteso.sweng.Login.UsersBean;

/**
 * Servlet implementation class SaveUserProfileServlet
 */
@WebServlet("/SaveUserProfileServlet")
public class SaveUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHandlerDummy q;// = new QueryHandlerDummy();  
	public QueryHandlerDummy getQ() {
		return q;
	}

	public void setQ(QueryHandlerDummy q) {
		this.q = q;
	}

	public UsersBean getU() {
		return u;
	}

	public void setU(UsersBean u) {
		this.u = u;
	}

	UsersBean u;// = q.getUserProfileInformation(userName);
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUserProfileServlet() {
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
		String lastName = request.getParameter("lastName");
		String birthday = request.getParameter("birthday");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		String favoriteTeam = request.getParameter("favoriteTeam");
		//String photo = request.getParameter("photo");
		//QueryHandlerDummy q = new QueryHandlerDummy();  
		//UsersBean u = new QueryHandlerDummy().getUserProfileInformation(userName);
		//setQ(new QueryHandlerDummy());
		//u = getQ(userName);
		setU(new QueryHandlerDummy().getUserProfileInformation(userName));
		
		u.setUserName(userName);
		u.setLastName(lastName);
		u.setBirthday(birthday);
		u.setCity(city);
		u.setCountry(country);
		u.setEmail(email);
		u.setFavoriteTeam(favoriteTeam);
		
		HttpSession session = request.getSession( );
		session.removeAttribute("userInformation");
		session.setAttribute("userInformation", u);	
		
		RequestDispatcher dispatcher=null;
		dispatcher = getServletContext().getRequestDispatcher( "/profilePage.jsp" );
		dispatcher.forward( request, response);
	}

}
