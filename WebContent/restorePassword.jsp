<%@page import="com.iteso.sweng.Login.verifyPasswordServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="verifyPasswordServlet" method="post">
		<center>
			<table class="title">
				<tr>
					<th>Restore password</th>
				</tr>
				<tr>
					<td><font color="blue"> Enter your new password </font></td>
				</tr>
			</table>
		</center>
		<table align="center">
			<tr>
				<td><strong>New password:</strong></td>
				<td><input type="password" name="newPassword" id="newPassword" /></td>
			</tr>
			<tr>
				<td><strong>Verify new password:</strong></td>
				<td><input type="password" name="verifyPassword" id="verifyPassword" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>