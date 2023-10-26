<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="ControllerServlet" method="post">

		<table>
			<tr>
			<td>Task Name</td>
			<td><input type="text" name="taskName"></td>
			</tr>
			<tr>
			<td>Task Description</td>
			<td><textarea name="taskDesc" rows="5" cols="40"></textarea></td>
			</tr>
			<tr><td><input type="submit" name="submit" value="CreateTask"></td></tr>

		</table>

	</form>

</body>
</html>