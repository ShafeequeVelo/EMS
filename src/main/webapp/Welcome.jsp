<%@page import="com.velociter.ems.helper.GetDesignations"%>
<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% 
String empID = session.getAttribute("empID").toString();

GetDesignations getDesignations = new GetDesignations();
String empDesg = getDesignations.determineEmpDesignation(empID);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ControllerServlet" method="post">

		<h3 align="center">
			Welcome 
			<%
		String fname = request.getAttribute("fName").toString();
		out.println(fname);
		%>
		</h3>

		<h4 align="center">This is your personal detail</h4>


		<table align="center" border="1">

			<input type="submit" name="submit" value="Logout">
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
					short age = Short.parseShort(request.getAttribute("age").toString());
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
		</table>

		<h4 align="center">This is your address detail</h4>


		<table align="center" border="1">

			<tr>
				<td>Address1</td>
				<td>
					<%
					String address1 = request.getAttribute("address1").toString();
					out.println(address1);
					%>
				</td>
			</tr>
			<tr>
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
					String zipCode = request.getAttribute("zipcode").toString();
					out.println(zipCode);
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
		</table>
		<table  align="center">
			<tr>
				<td>
				<% if(empDesg != null && empDesg.equals("ADMIN")) { %>
				<input type="submit" name="submit" value="Add Manager" >
				<% }
				else if(empDesg != null && empDesg.equals("MANAGER")){
				%>
				<input type="submit" name="submit" value="Add Employee" >
				<input type="submit" name="submit" value="Add Tasks" >
				<%}
				else if(empDesg != null && empDesg.equals("DEVELOPER") || empDesg.equals("TESTER")){
				%>
				<input type="submit" name="submit" value="Show Tasks">
				<%} %>
				
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
