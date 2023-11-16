<%@page import="com.velociter.ems.pojo.RolePojo"%>
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
List<RolePojo> roles = (List<RolePojo>) session.getAttribute("roles");
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

    input[type="text"] {
        padding: 10px;
        margin: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    .submit {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        padding: 10px;
        margin: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .content{
	padding-top: 60px;
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <form action="ControllerServlet" method="post"><input type="submit" name="submit" value="Logout" class="logout-button"></form>  -->
</head>
<body>
	    
<jsp:include page="Header.jsp"></jsp:include>
<div class="content">

<!--<jsp:include page="Logout.jsp"></jsp:include> -->

	<table align="center">

		<tr>
			<th>Role List:</th>
		</tr>
		<%
		if (roles != null) {
			for (RolePojo role : roles) {
		%>
		<tr>
			<td><input type="checkbox"> <%
 out.print(role.getRoleName());
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
				<th>Role</th>
				<td><input type="text" name="roleName">
				</td>
			
				<td><input type="submit" name="submit" value="Create Role" class="submit"></td>
			
			</tr>
	</table>
	</form>
	<form action="ControllerServlet" method="post"><input type="submit" name="submit" value="Back" class="submit"></form>
</div>
</body>
</html>
<% 
}
%>