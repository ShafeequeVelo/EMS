<%@page import="com.velociter.ems.helper.GetDesignations"%>
<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<RegistrationPojo> employeeList = (List<RegistrationPojo>) request.getAttribute("employeeList");
List<RegistrationPojo> managerList = (List<RegistrationPojo>) request.getAttribute("managerList");
GetDesignations getDesignations = new GetDesignations();
List<String> designations = null;
List<String> designationForManager = getDesignations.getDesignationForManager();
String desig = getDesignations.determineEmpDesignation(session.getAttribute("empID").toString());
if (desig.equals("ADMIN")) {
	designations = getDesignations.getDesignationForAdmin();
} else {
	designations = getDesignations.getDesignationForManager();
}

if(employeeList == null){
	out.println("No employees left to assign a role");
}
else{
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h4 align="center">Employee List</h4>

	<table border="1">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Emp ID</td>
			<td>Email</td>
			<td>Designation</td>
		</tr>
		<%
		for (RegistrationPojo registrationPojo : employeeList) {
			out.println("<form action='ControllerServlet' method='post'>");
			out.println("<tr>");
			out.println("<td>");
			out.println(registrationPojo.getfName());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getlName());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getEmpID());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getEmail());
			out.println("</td>");
		%>
		<td><input type="hidden" name="EmpID"
			value="<%out.print(registrationPojo.getEmpID());%>"> <select
			name="designation" id="designationID" required>

				<option value="">Select Designation</option>

				<%
				for (String designation : designations) {
				%>
				<option value="<%=designation%>"><%=designation%></option>
				<%
				}
				%>

		</select></td>
		<td><input type="submit" name="submit"
			value="EmployeeDesignation"></td>
			
			
		</form>
		<%
		out.println("</tr>");
		}
		%>
	</table>
<% } %>
	
	<br>
	<br>
	<br>
	<br>

	<table border="1">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Emp ID</td>
			<td>Email</td>
			<td>Designation</td>
		</tr>
		<%
		for (RegistrationPojo registrationPojo : managerList) {
			//			out.println("<form action='ControllerServlet' method='post'>");
			out.println("<tr>");
			out.println("<td>");
			out.println(registrationPojo.getfName());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getlName());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getEmpID());
			out.println("</td>");

			out.println("<td>");
			out.println(registrationPojo.getEmail());
			out.println("</td>");

			out.println("<td>");
			out.println(getDesignations.determineEmpDesignation(registrationPojo.getEmpID()));
			out.println("</td>");

			out.println("</tr>");
		}
		%>
	</table>
</body>
</html>