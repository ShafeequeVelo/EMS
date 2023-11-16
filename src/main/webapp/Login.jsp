<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<link rel="stylesheet" href="Style.css" type="text/css"/>
<body>

<form action="ControllerServlet" class="form3" method="post">
<h3 align="center">Login Page</h3>

<table align="center">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uName" required="required"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>
			<table align="center">
			<tr>
				<td><input type="submit" name="submit" value="Login"></td>
			
				<td><input type="reset" name="reset" value="Reset"></td>
			</tr>
			</table>


		</table>


	</form>
</section>

</body>
</html>