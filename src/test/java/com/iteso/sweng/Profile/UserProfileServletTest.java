package com.iteso.sweng.Profile;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.mock.MockName;

import com.iteso.sweng.Login.UsersBean;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserProfileServletTest {
	
	@Test
	public void UserProfile() throws ServletException, IOException{
	UserProfileServlet servlet = new UserProfileServlet();

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    RequestDispatcher dispatcher = mock(RequestDispatcher.class);
    HttpSession session = mock(HttpSession.class);
    UsersBean u = mock(UsersBean.class);
    
    servlet.setUsersBean(u);
    
    when(request.getParameter("userName")).thenReturn("Luis") ;
    when(request.getSession()).thenReturn(session);
    when(servlet.getUsersBean()).thenReturn(u);
    //((ServletRequest) when(session)).setAttribute("userInformation", u);
    dispatcher = request.getRequestDispatcher(  "/profilePage.jsp"  );
	servlet.doPost(request, response);
	verify(dispatcher).forward(request, response);
	}
	
}
