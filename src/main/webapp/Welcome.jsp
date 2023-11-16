<%@page import="com.velociter.ems.pojo.RolePojo"%>
<%@page import="com.velociter.ems.helper.Operations"%>
<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="Style.css" type="text/css"/>
<body>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

if (session.getAttribute("empID")== null) {

	response.sendRedirect("index.jsp");

} else {
%>

	<%
	String sessionEmpId = session.getAttribute("empID").toString();
	String roleName = request.getAttribute("roleName").toString();
	RolePojo rolePojo = new RolePojo();
	
	%>
	<section class="container">
	<form action="ControllerServlet" class="form3" method="post">
	  
		<h3 align="center">
			Welcome
			<%
		String fname = request.getAttribute("fName").toString();
		out.println(fname);
		%>
		</h3>

		<h4 align="center">This is your detail</h4>


		<table align="center" border="1">
		
		
			<tr>
				<td>First Name</td>
				<td>
					<%
					out.println(fname);
					%>
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>
					<%
					String lname = request.getAttribute("lName").toString();
					out.println(lname);
					%>
				</td>
			</tr>
			<tr>
				<td>Emp ID</td>
				<td>
					<%
					String empid = request.getAttribute("empID").toString();
					out.println(empid);
					%>
				</td>
			</tr>
			<tr>
				<td>Age</td>
				<td>
					<%
					int age = Integer.parseInt(request.getAttribute("age").toString());
					out.println(age);
					%>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<%
					String gender = request.getAttribute("gender").toString();
					out.println(gender);
					%>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<%
					String email = request.getAttribute("email").toString();
					out.println(email);
					%>
				</td>
			</tr>
			<tr>
				<td>Phone</td>
				<td>
					<%
					String phone = request.getAttribute("phone").toString();
					out.println(phone);
					%>
				</td>
			</tr>
			</section>
		</table>
		<table align="center" border="1">
		<h3 align="center">This is your address detail</h3>
		<tr>
				<td>Address</td>
				<td>
					<%
					String address1 = request.getAttribute("address1").toString();
					out.println(address1);
					%>
				</td>
			</tr>
		
			<tr>
				<td>City</td>
				<td>
					<%
					String city = request.getAttribute("city").toString();
					out.println(city);
					%>
				</td>
			</tr>
			<tr>
				<td>ZipCode</td>
				<td>
					<%
					int zipcode = Integer.parseInt(request.getAttribute("zipcode").toString());
					out.println(zipcode);
					%>
				</td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<%
					String state = request.getAttribute("state").toString();
					out.println(state);
					%>
				</td>
			</tr>
			<tr>
				<td>Country</td>
				<td>
					<%
					String country = request.getAttribute("country").toString();
					out.println(country);
					%>
				</td>
			</tr>
			</table></br>
			<table align="center">
				<tr>
				<%
				if(roleName.equals("ADMIN")){
				
				%>
				<td><input type="submit" name="submit" value="CreateDepartment"></td>
				<td><input type="submit" name="submit" value="CreateRole"></td>
				<%
				}
				%>
				<td><input type="submit" name="submit" value="Logout"></td>
	
		</tr>
			</tr>
			<%
}
				%>
		
		</table>
	</form>
</body>
</html>