<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

form {
	padding: 20px;
	background: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
	margin-top: 10px;
}

table {
	width: 100%;
}

table td {
	padding: 10px 0;
}

input[type="text"], input[type="password"], input[type="submit"], input[type="reset"],
	.register-btn {
	width: 90%;
	padding: 8px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
	display: block;
	margin-top: 10px;
}

input[type="submit"], input[type="reset"] {
	width: 100%;
	margin-top: 10px;
	background-color: #4CAF50;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover, input[type="reset"]:hover {
	background-color: #45a049;
}

input[type="text"], input[type="password"] {
	width: calc(100% - 20px);
}

.registration-success {
	text-align: center;
	margin-top: 20px; /* Adjust the margin top as needed */
}

.registration-success h2 {
	color: #4CAF50; /* Change the color as desired */
}

.registration-success p {
	color: #333; /* Change the color as desired */
}
</style>

<meta charset="ISO-8859-1">
<title>Login Page</title>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function() {
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
	<%
	if (request.getAttribute("checkIfRegistired") == null) {
	%>
	<form action="ControllerServlet" method="post">
		<table align="center">
			<tr>
				<td><input type="submit" name="submit" value="Register Now"></td>

			</tr>
		</table>
	</form>
	<%
	} else {
	%>
	<div class="registration-success">
		<h2>Registration Successful</h2>
		<p>Thank you for registering with us! You can now login with your
			credentials.</p>
	</div>
	<%
	}
	%>
</body>
</html>
