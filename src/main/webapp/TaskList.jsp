<%@page import="java.util.List"%>
<%@page import="com.velociter.ems.pojo.TasksPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
</head>
<body>
<% List<TasksPojo> taskList = (List<TasksPojo>) request.getAttribute("taskList");%>
	<form action="ControllerServlet" method="post">
		<table align="center" border="1">
		<h3 align="center">Enter the task.</h3>
		<tr>
			<td>Task</td>
			<td><input type="text" name="task"></td> 
			</tr>
			<tr>
			<td>TaskDescription</td>
			<td><input type="text" name="taskDescription"></td>
			</tr>
			<table align="center">
			<tr>
			<td><input type="submit" name="submit" value="Add Task"></td>
			</tr>
			</table>
			</table></br>
			<table align="center" border="1">
			<h3 align="center">This is a task.</h3>
			<tr>
			<td>Tasks</td>
			<td>TaskDescription</td>
			<td>TaskStatus</td>
			<td>TaskAssignee</td>
			<td>TasksAssigner</td>
			</tr>
		<%
		for(TasksPojo tasksPojo : taskList){
			out.print("<tr>");
			out.print("<td>");
			out.print(tasksPojo.getTask());
			out.print("</td>");
			out.print("<td>");
			out.print(tasksPojo.getTaskDescription());
			out.print("</td>");
			out.print("<td>");
			out.print(tasksPojo.getTaskStatus());
			out.print("</td>");
			out.print("<td>");
			out.print(tasksPojo.getTaskAssignee());
			out.print("</td>");
			out.print("<td>");
			out.print(tasksPojo.getTaskAssigner());
			out.print("</td>");
			out.print("</tr>");
		}
		%>

		</table>
	</form>

</body>
</html>