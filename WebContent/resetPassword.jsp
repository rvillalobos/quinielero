<%@page import="com.iteso.sweng.Login.validateUserAndEmailServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
<script src="SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="validateUserAndEmailServlet" method="post">
		<center>
			<ul id="MenuBar1" class="MenuBarHorizontal">
			  <li><a href="#">Main Page</a>		      </li>
			  <li><a href="#">Teams</a></li>
			  <li><a href="#">Pools</a>		      </li>
			  <li><a href="../../Qunielero_P1/web/FAQ.html">FAQ</a></li>
		  </ul>
			<p>&nbsp;</p>
			<table class="title">
				<tr>
					<th>Reset password</th>
				</tr>
				<tr>
					<td><font color="blue"> For reset your password,
							please enter your user name and E-mail to validate </font></td>
				</tr>
			</table>
		</center>
		<table align="center">
			<tr>
				<td><strong>User name:</strong></td>
				<td><input type="text" name="userName" id="userName" /></td>
			</tr>
			<tr>
				<td><strong>E-mail:</strong></td>
				<td><input type="text" name="eMail" id="eMail" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"SpryAssets/SpryMenuBarRightHover.gif"});
    </script>
</body>
</html>