<%@page import="com.velociter.ems.pojo.StatePojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<style type="text/css"> 	 
input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
}

input[type=number] {
	-moz-appearance: textfield;
}
</style>
</head>
<body>
<h3 align="center">Personal Details</h3>
	<form action="ControllerServlet" method="post">
		<table align="center">
		
			<tr>
				<td>First Name <span style="color:red">*</span></td>
				<td><input type="text" name="fName" oninput="this.value = 
				this.value.replace(/[^a-zA-Z]/g, '')" required></td>
			</tr>
			<tr>
				<td>Last Name <span style="color:red">*</span></td>
				<td><input type="text" name="lName" 
				oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')" required></td>
			</tr>
			<tr>
				<td>EmpID <span style="color:red">*</span></td>
				<td><input type="text" name="empid" required="required" pattern="[a-zA-Z0-9]+"></td>
			</tr>
			<tr>
				<td>Age <span style="color:red">*</span></td>
				<td><input type="number" name="age" min="1" max="100"
					value="25" oninput="this.value = this.value.replace(/[^0-9]/g, ''); limitInputLength(this,2)" ></td>
			</tr>
			<tr>
				<td colspan="1">Gender <span style="color:red">*</span></td>
				    <td><input type="radio" name="gender" value="Male">Male 
        			<input type="radio" name="gender" value="Female">Female
                 	<input type="radio" name="gender" value="others"> Others </td>
			</tr>
			
			<tr>
				<td>Phone <span style="color:red">*</span></td>
				<td><input type="text" name="phone" pattern="[0-9]{10}" oninput="limitInputLength(this,10)" required></td>
			</tr>
			<tr>
			<td>Email <span style="color:red">*</span></td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<td>Username <span style="color:red">*</span></td>
				<td><input type="text" name="uName" required="required" pattern="[a-zA-Z0-9]+"></td>
			</tr>
			<tr>
				<td>Password<span style="color:red">*</span></td>
				<td ><input type="password" name="password" required="required" maxlength="8"></td>
			</tr>
			<tr>
				<td colspan="2"><jsp:include page="Address.jsp"></jsp:include></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit" value="Register" ></td>
			
			   <td><input type="reset" name="reset" value="Reset" ></td>
			</tr>

		</table>
<h3>Note: Fields with a red asterisk (<span style="color:red">*</span>) are mandatory.</h3>

	</form>
	
	<form action="ControllerServlet" method="post">
	<table><tr><td>
	 	<input type="submit" name="submit" value="Login Now">
	</td></tr></table>
	</form>

</body>
</html>