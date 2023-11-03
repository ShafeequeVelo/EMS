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
        padding: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        text-align: center;
    }

    form {
        width: 300px;
        background: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2, h4 {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        background-color: #4CAF50;
        color: white;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
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