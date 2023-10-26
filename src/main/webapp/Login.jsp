<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<script>
    history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
    };
</script>
</head>
<body>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
%>
<form action="ControllerServlet" method="post">
<table align="center">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uName" required="required"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			
			<tr>
			<td><input type="submit" name="submit" value="Login"></td>
			<td><input type="reset" name="reset" value="Reset"></td>
			</tr>

		</table>


	</form>
	
	<form action="ControllerServlet" method="post">
	<table align="left"><tr>
				<td><input type="submit" name="submit" value="Register Now"></td>

	</tr></table>
</body>
</html>
