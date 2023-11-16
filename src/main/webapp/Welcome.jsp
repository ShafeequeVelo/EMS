<%@page import="com.velociter.ems.pojo.RolePojo"%>
<%@page import="com.velociter.ems.helper.GetDesignations"%>
<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
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
String empID = session.getAttribute("empID").toString();
String roleName = request.getAttribute("roleName").toString();
RolePojo rolePojo = new RolePojo();

//GetDesignations getDesignations = new GetDesignations();
//String empDesg = getDesignations.determineEmpDesignation(empID);
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

h3, h4 {
	text-align: center;
}

table {
	margin: 20px auto;
	border: 1px solid #000;
	border-collapse: collapse;
	width: 80%;
}

table td {
	padding: 8px;
	border: 1px solid #000;
}

.submit {
	width: 160px; /* Adjusted width to fit the button text */
	margin: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	border-radius: 5px;
	cursor: pointer;
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
</head>
<body>
	<form action="ControllerServlet" method="post">
		<jsp:include page="Header.jsp"></jsp:include>

		<div class="content">

			<!-- <input type="submit" name="submit" value="Logout" class="logout-button">  -->
			<!--  	<jsp:include page="Logout.jsp"></jsp:include> -->
			<h3 align="center">
				Welcome
				<%
			String fname = request.getAttribute("fName").toString();
			out.println(fname);
			%>
			</h3>

			<h4 align="center">This is your personal detail</h4>


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
	</form>

	<form action="ControllerServlet" method="post">

		<table align="center">

			<tr>

				<%
				if (roleName.equals("ADMIN")) {
				%>

				<td align="center"><input type="submit" name="submit"
					value="Manage Roles" class="submit"></td>

				<td align="center"><input type="submit" name="submit"
					value="Manage Departments" class="submit"></td>

					<td align="center"><input type="submit"
					class="submit" name="submit" value="Change Password"></td>

				<%
				}
				%>

			</tr>

		</table>



	</form>
	</div>
</body>
</html>
<%
}
%>
