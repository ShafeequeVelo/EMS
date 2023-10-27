<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@page import="com.velociter.ems.helper.GetDesignations"%>
<%@page import="com.velociter.ems.helper.TaskOperations"%>
<%@page import="com.velociter.ems.pojo.TaskPojo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<TaskPojo> taskList = new ArrayList<TaskPojo>();
TaskOperations taskOp = new TaskOperations();
GetDesignations getDesignations = new GetDesignations();
String empID = (String) session.getAttribute("empID");
List<RegistrationPojo> assigneeList = getDesignations.getEmpForMgr(empID);
%>
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
			<tr>
				<td><input type="submit" name="submit" value="CreateTask"></td>
			</tr>


		</table>

	</form>
	<br>
	<br>

	<%
	taskList = taskOp.getTaskList();
	if (taskList == null) {
		out.println("Zero number of tasks available");
	} else {
	%>
	<table border="1">
		<tr>
			<td>Task</td>
			<td>Task Description</td>
			<td>Assigner</td>
			<td>Task Status</td>
			<td>Assignee</td>
		</tr>
		<%
		for (TaskPojo taskPojo : taskList) {

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
			out.println(taskPojo.getStatus());
			out.println("</td>");
		%>

		<td><select name="assignee" id="assigneeID" required>
				<%
				for (RegistrationPojo assignee : assigneeList) {
				%>
				<option value="<%=assignee.getfName()%>"><%=assignee.getfName()%></option>
				<%
				}
				%>

		</select></td>
		<input type="hidden" name="taskid"
			value="<%out.print(taskPojo.getTaskID());%>">
		<td><input type="submit" name="submit" value="updateTask">
		</td>

		<%
		out.println("</tr>");
		}
		%>
		</form>
	</table>
	<%
	}
	%>


</body>
</html>