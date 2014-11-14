package com.iteso.sweng.Profile;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.iteso.sweng.Login.UsersBean;

public class SaveUserProfileServletTest {

	@Test
	public void SaveUserProfile() throws ServletException, IOException{
		SaveUserProfileServlet servlet = new SaveUserProfileServlet();

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		RequestDispatcher dispatcher = mock(RequestDispatcher.class);
		HttpSession session = mock(HttpSession.class);

		when(request.getParameter("userName")).thenReturn("Luis") ;
		when(request.getParameter("lastName")).thenReturn("Garcia") ;
		when(request.getParameter("birthday")).thenReturn("10/Enero") ;
		when(request.getParameter("city")).thenReturn("Guadalajara") ;
		when(request.getParameter("country")).thenReturn("Mexico") ;
		when(request.getParameter("email")).thenReturn("Luis@soft.com") ;
		when(request.getParameter("favoriteTeam")).thenReturn("America") ;
		UsersBean u = mock(UsersBean.class);
		servlet.setU(u);
		when(request.getSession()).thenReturn(session);
				
		
		dispatcher = request.getRequestDispatcher(  "/profilePage.jsp"  );
		servlet.doPost(request, response);
		verify(dispatcher).forward(request, response);

	}

}
