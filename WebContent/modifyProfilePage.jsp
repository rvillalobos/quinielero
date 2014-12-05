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
<script language="javascript" type="text/javascript" src="functions.js"></script>
<%@page import="com.iteso.sweng.Login.UsersBean"%>
<%@page import="com.iteso.sweng.Pool.PoolQueryHandlerDummy"%>
<%@page import="com.iteso.sweng.Profile.SaveUserProfileServlet"%>
<%
	UsersBean u = (UsersBean) session.getAttribute("userInformation");
	PoolQueryHandlerDummy p = new PoolQueryHandlerDummy();
%>
<body>
	<ul id="MenuBar1" class="MenuBarHorizontal">
	  <li><a href="#">Main Page</a>      </li>
	  <li><a href="#">Teams</a></li>
	  <li><a href="#">Pools</a>      </li>
	  <li><a href="../../Qunielero_P1/web/FAQ.html">FAQ</a></li>
</ul>
	<p>&nbsp;</p>
	<table>
		<tr>
			<td><img src=<%out.print(" " + u.getPhoto() + " ");%> id="photo"
				name="photo"></td>
		</tr>
	</table>
	<form method="POST" action="SaveUserProfileServlet">
		<table>
			<tr>
				<td><strong>Name: </strong></td>
				<td><input type="text" name="userName" id="userName"
					value="<%=u.getUserName()%>" readonly /></td>
			</tr>
			<tr>
				<td><strong>Last name: </strong></td>
				<td><input type="text" name="lastName" id="lastName"
					value="<%=u.getLastName()%>" /></td>
			</tr>
			<tr>
				<td><strong>Birthday: </strong></td>
				<td><input type="text" name="birthday" id="birthday"
					value="<%=u.getBirthday()%>" /></td>
			</tr>
			<tr>
				<td><strong>City: </strong></td>
				<td><input type="text" name="city" id="city"
					value="<%=u.getCity()%>" /></td>
			</tr>
			<tr>
				<td><strong>Country: </strong></td>
				<td><input type="text" name="country" id="country"
					value="<%=u.getCountry()%>" /></td>
			</tr>
			<tr>
				<td><strong>E-mail: </strong></td>
				<td><input type="text" name="email" id="email"
					value="<%=u.getEmail()%>" /></td>
			</tr>
			<tr>
				<td><strong>Favorite team: </strong></td>
				<td><select name="favoriteTeam">
						<%
							for (int x = 0; x < p.getAvailableTeams().size(); x++) {
								out.print("<option value="
										+ p.getAvailableTeams().get(x).getName() + ">"
										+ p.getAvailableTeams().get(x).getName() + "</option>");
							}
						%>

				</select></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">Save changes</button></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>
</body>
</html>


