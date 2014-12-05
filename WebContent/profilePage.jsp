<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile page</title>
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css">
</head>
<%@page import="com.iteso.sweng.Login.UsersBean" %>
<% 
	UsersBean u = (UsersBean) session.getAttribute("userInformation");
%> 
<body>
<p>&nbsp;</p>
	<ul id="MenuBar1" class="MenuBarHorizontal">
	  <li><a href="#">Main Page</a>      </li>
	  <li><a href="#">Teams</a></li>
	  <li><a href="#">Pools</a>      </li>
	  <li><a href="#">FAQ</a></li>
</ul>
	<p>&nbsp;</p>
	<table>
		<tr>
			<td><img src= <%out.print(" "+ u.getPhoto()+ " ");%>  id="photo"
				name="photo"></td>
	  </tr>
</table>

<table>
		<tr>
			<td><strong>Name: </strong></td>
			<td><%=u.getUserName() %></td>
		</tr>
		<tr>
			<td><strong>Last name: </strong></td>
			<td><%=u.getLastName() %></td>
		</tr>
		<tr>
			<td><strong>Birthday: </strong></td>
			<td><%=u.getBirthday() %></td>
		</tr>
		<tr>
			<td><strong>City: </strong></td>
			<td><%=u.getCity() %></td>
		</tr>
		<tr>
			<td><strong>Country: </strong></td>
			<td><%=u.getCountry() %></td>
		</tr>
		<tr>
			<td><strong>E-mail: </strong></td>
			<td><%=u.getEmail() %></td>
		</tr>
		<tr>
			<td><strong>Favorite team: </strong></td>
			<td><%=u.getFavoriteTeam() %></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td> <a href="modifyProfilePage.jsp">Modify my profile data</a> </td>
		</tr>
	</table>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>
</body>
</html>