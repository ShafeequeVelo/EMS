<%@page import="com.velociter.ems.pojo.DepartmentPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

response.setHeader("Pragma", "no-cache"); // HTTP 1.0.

response.setDateHeader("Expires", 0);

 

if (null == session.getAttribute("empID")) {

     response.sendRedirect("index.jsp");

} else {

%>
    
<%
List<DepartmentPojo> Departments = (List<DepartmentPojo>) session.getAttribute("Departments");
%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 20px;
    }

    table {
        margin: 20px auto;
        border-collapse: collapse;
        width: 80%;
    }

    table th,
    table td {
        border: 1px solid #000;
        padding: 8px;
    }

    input[type="text"],
    input[type="submit"] {
        padding: 10px;
        margin: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<!--<form action="ControllerServlet" method="post"><input type="submit" name="submit" value="Logout" class="logout-button"></form>  -->
<!--<jsp:include page="Logout.jsp"></jsp:include> -->
	<table align="center">

		<tr>
			<th>Departments List:</th>
		</tr>
		<%
		if (Departments != null) {
			for (DepartmentPojo Department : Departments) {
		%>
		<tr>
			<td><input type="checkbox"> <%
 out.print(Department.getDepartmentName());
 %></td>
		</tr>
		<%
		}
		}
		%>
	</table>

<form action="ControllerServlet" method="post">
	<table align="center">
		
			<tr>
				<th>Department</th>
				<td><input type="text" name="DepartmentName">
				</td>
			
				<td><input type="submit" name="submit" value="Create Department" class="submit"></td>
			
			</tr>
	</table>
	</form>
	<form action="ControllerServlet" method="post"><input type="submit" name="submit" value="Back" class="submit"></form>

</body>
</html>
<% } %>