<%@page import="java.util.ArrayList"%>
<%@page import="com.velociter.ems.pojo.TaskPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<TaskPojo> tasksForEmp = new ArrayList<TaskPojo>();
tasksForEmp = (List<TaskPojo>) request.getAttribute("tasksForEmp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h4>Task List</h4>

	<%
	if (tasksForEmp == null) {
		out.println("Zero number of tasks available");
	} else {
	%>
	<table border="1">
		<tr>
			<td>Task</td>
			<td>Task Description</td>
			<td>Assigner</td>
			<td>Assignee</td>
			<td>Task Status</td>
		</tr>
		<%
		for (TaskPojo taskPojo : tasksForEmp) {

			out.println("<form action='ControllerServlet' method='post'>");
			out.println("<tr>");
			out.println("<td>");
			out.println(taskPojo.getTask());
			out.println("</td>");

			out.println("<td>");
			out.println(taskPojo.getTaskDesc());
			out.println("</td>");

			out.println("<td>");
			out.println(taskPojo.getAssigner());
			out.println("</td>");

			out.println("<td>");
			out.println(taskPojo.getAssignee());
			out.println("</td>");
		%>
		<td><select name="status" id="statusID">
				<option value=" <%out.print(taskPojo.getStatus());%>">
					<%
					out.print(taskPojo.getStatus());
					%>
				</option>
				<option value="InProgress">In Progress</option>
				<option value="Completed">Completed</option>
		</select> </select></td>

		<input type="hidden" name="taskid"
			value="<%out.print(taskPojo.getTaskID());%>">

		<td><input type="submit" name="submit" value="updateTaskForEmp">
		</td>
		<%
		out.println("</tr>");
		}
		%>
		</form>
		
	</table>
	<form action="ControllerServlet" method="post">
		<input type="submit" name="submit" value="Logout"> </form>
	<%
	}
	%>

</body>
</html>