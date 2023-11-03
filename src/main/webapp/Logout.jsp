<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
     .logout-button {
     background-image:url('power-button.png');
     background-size: cover;
     background-position : center;
     background-repeat: no-repeat;
     width: 100px;
     color :green;
     height : 70px;
     border: none;
	 text-indent: -9999px;
	 cursor: pointer;
        }
</style>
<form action="ControllerServlet" method="post">
<input type="submit" name="submit" value="Logout" class="logout-button">
</form>
</body>
</html>