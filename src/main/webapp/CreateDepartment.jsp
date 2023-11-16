<%@page import="com.velociter.ems.pojo.DepartmentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<DepartmentPojo> departList = (List<DepartmentPojo>) request.getAttribute("departList");%>
<form action="ControllerServlet" method="post">
		<table align="center" >
		<h3 align="center">Create Department</h3>
		<tr>
			<td>DepartmentID</td>
			<td><input type="text" name="departmentId"></td> 
			</tr>
			<tr>
			<td>DepartmentName</td>
			<td><input type="text" name="departmentName"></td>
			</tr>
			<table align="center">
			<tr>
			<td><input type="submit" name="submit" value="Create Department"></td>
			</tr>
			</table>
			</table></br>
			<!-- 
				<table align="center" border="1">
			<h3 align="center">This is a Department.</h3>
			<tr>
			<td>DepartmentID</td>

			<td>DepartmentName</td>
					
			<%
			if (departList != null) {
				for(DepartmentPojo departmentPojo : departList){
		
			out.print("<tr>");
			out.print("<td>");
			out.print(departmentPojo.getDepartmentID());
			out.print("</td>");
			out.print("<td>");
			out.print(departmentPojo.getDepartmentName());
			out.print("</td>");
			out.print("</tr>");
		}
			}
		%>
	
			</tr>


		</table>
			-->
	</form>
		

</body>
</html>