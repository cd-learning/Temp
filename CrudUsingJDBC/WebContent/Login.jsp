<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="LoginValidate">
		
		<p align="center" style="font-size:large;"><b>Login</b></p>
		<table border="1" align="center">
			
			<tr>
				<td scope="col">Username :</td>
				<td><input type="text" name="username" required></td>
			</tr>
			
			<tr>
				<td scope="col">Password  :</td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center" scope="col"><input type="submit" value="Login" ></td>
			</tr>
			
		</table>
		
	</form>
	<br><br>
	<center><a href="UserRegistration.jsp">New User</a></center>
</body>
</html>