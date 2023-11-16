<%@page import="com.velociter.ems.helper.RoleOperation"%>
<%@page import="com.velociter.ems.pojo.RolePojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Role</title>
</head>
<body>
<form action="ControllerServlet" method="post">
<% List<RolePojo> role = (List<RolePojo>) request.getAttribute("roles");%>
		<table align="center">
		<h3 align="center">Create Role</h3>
		<tr>
			<td>RoleID</td>
			<td><input type="text" name="roleId"></td> 
			</tr>
			<tr>
			<td>RoleName</td>
			<td><input type="text" name="roleName"></td>
			</tr>
			<table align="center">
			<tr>
			<td><input type="submit" name="submit" value="Create Role"></td>
			</tr>
			</table>
			</table></br>
		<!-- 		<table align="center" border="1">
			<h3 align="center">This is a role.</h3>
			<tr>
			<td>RoleID</td>

			<td>RoleName</td>
			
			<%
			if(role != null){
		for(RolePojo rolePojo : role){
			out.print("<tr>");
			out.print("<td>");
			out.print(rolePojo.getRoleID());
			out.print("</td>");
			out.print("<td>");
			out.print(rolePojo.getRoleName());
			out.print("</td>");
			out.print("</tr>"); 
		}
			}
		%>
			
			</tr>
	 -->	

		</table>
	</form>
			
		
	</form>

</body>
</html>