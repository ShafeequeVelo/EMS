<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<form action="ControllerServlet" method="post">
	<h2>Welcome to this page</h2>
	<h4>If you are already registered please click on login button else click on Register button</h4>
	<table>
		<tr>
			<td><input type="submit" name="submit" value="Register Now"></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="Login Now"></td>
		</tr>
	</table>
	
</form>
</body>
</html>