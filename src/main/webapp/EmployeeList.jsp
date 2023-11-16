<%@page import="com.velociter.ems.helper.Operations"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.velociter.ems.pojo.DesignationPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<% List<RegistrationPojo> employee = (List<RegistrationPojo>) request.getAttribute("employee"); %>
<% List<String> designations = (List<String>)request.getAttribute("designations");  
 Map<RegistrationPojo, DesignationPojo> managerList =(Map<RegistrationPojo, DesignationPojo>) request.getAttribute("managerList");
%>
<%
String sessionEmpId = session.getAttribute("empID").toString();

Operations operations = new Operations();

%>

	<form action="ControllerServlet" method="post">
		<h3 align="center">Employees List</h3>
		<table align="center" border="1">
			<tr>

				<td>First Name</td>
				<td>Last Name</td>
				<td>EmpID</td>
				<td>Age</td>
				<td>Gender</td>
				<td>Email</td>
				<td>Phone</td>
				<td>Designation</td>
				
			</tr>
			<%
			
			for (RegistrationPojo registrationPojo : employee) {
				out.print("<tr>");
				out.print("<td>");
				out.print(registrationPojo.getfName());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getlName());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getEmpID());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getAge());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getGender());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getEmail());
				out.print("</td>");
				out.print("<td>");
				out.print(registrationPojo.getPhone());
				out.print("</td>");
				out.print("<td>");
%>
<input type="hidden" name="EmpID" value="<%out.print(registrationPojo.getEmpID()); %>">
<select name="designation">
<option value="">Select Designation</option>
<%
		for (String designation2 : designations) {
		%>
		<option value="<%=designation2%>"><%=designation2%></option>
		<%
		}
		%>
</select>
	
<td><input type="submit" name="submit" value="Save" ></td>
			
<%
				out.print("</td>");
				out.print("</tr>");
				
			}
			%>
			
			
		</table> <br>
		
		<table align="center" border="1">
		<tr>

				<td>First Name</td>
				<td>Last Name</td>
				<td>EmpID</td>
				<td>Age</td>
				<td>Gender</td>
				<td>Email</td>
				<td>Phone</td>
				<td>Designation</td>
				
			</tr>
			
			<%

			for(RegistrationPojo rp : managerList.keySet()){
				
				out.print("<tr>");
				out.print("<td>");
				out.print(rp.getfName());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getlName());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getEmpID());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getAge());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getGender());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getEmail());
				out.print("</td>");
				out.print("<td>");
				out.print(rp.getPhone());
				out.print("</td>");
				out.print("<td>");
				out.print((managerList.get(rp)).getDesignationName());
				//out.print(operations.getDesignationForAdmin(rp.getEmpID()));
				
				
				out.print("</td>");
				out.print("</tr>");
			}

			%>
		
		</table>
	</form>
</body>
</html>