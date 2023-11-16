<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<style>

</style>

<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<link rel="stylesheet" href="Style.css" type="text/css"/>
<body>
<h3 align="center">Personal Details</h3>
<section class="container">
	<form action="ControllerServlet" class="form2" method="post">
		<table align="center">
		<div class="input-box">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fName" oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')" required="required"></td>
			</tr>
			</div>
			<div class="input-box">
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lName" oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')" required="required"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>EmpID</td>
				<td><input type="text" name="empid" oninput="this.value = this.value.replace(/[a-zA-Z0-9]+, '')" required="required" pattern="[a-zA-Z0-9]+"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" required="required" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="2"></td>
			</tr>
			</div>
			<div class="gender-box">
			<tr>
				<td colspan="1">Gender</td>
				    <td> <input type="radio" name="gender" value="Male">Male 
        			<input type="radio" name="gender" value="Female">Female
                 	<input type="radio" name="gender" value="others"> Others </td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>Phone</td>
				<td><input type="text" name="phone" required="required" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="10"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
			<td>Email</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>Username</td>
				<td><input type="text" name="uName" required="required" pattern="[a-zA-Z0-9]+"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password" required="required" maxlength="8"></td>
			</tr>
			</div>
			
			<div class="input-box">
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmpassword" id="confirmPassword" required="required" maxlength="8"></td>
			</tr>
			</div>
		<script>
		function checkPasswordMatch() {
			var password = document.getElementById("password");
			var confirmPassword = document.getElementById("confirmPassword");

			if (password.value !== confirmPassword.value) {
				confirmPassword.setCustomValidity("Passwords Mismatch");
			} else {
				confirmPassword.setCustomValidity("");
			}
		}

		window.onload = function() {
			var confirmPassword = document.getElementById("confirmPassword");
			confirmPassword.onkeyup = checkPasswordMatch;
		};
		
		</script>
			<tr>
				<td colspan="2"><jsp:include page="Address.jsp"></jsp:include></td>
			</tr>
			<tr>
				<td>Department</td>
				<td><select name="DepartmentID" id="Department" required="required">
				<option value="">Select</option>
				</select></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><select name="RoleID" id="Role" required="required">
				<option value="">Select</option>
				</select></td>
			</tr>
			<tr>
				<td>Manager</td>
				<td><select name="ManagerID" id="Manager">
				<option value="">Select</option>
				</select></td>
			</tr>
			
			<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(
			function() {
				var departmentDropdown = $("#Department");

				$.get("DepartmentServlet", function(data, status) {
					$.each(data, function(index, department) {
						departmentDropdown.append($('<option></option>').attr(
								'value', department.departmentID).text(
								department.departmentName));
						
					});
				});
			});
</script>
<script>
	$(document).ready(
			function() {
				var roleDropdown = $("#Role");

				$.get("RoleServlet", function(data, status) {
					$.each(data, function(index, role) {
						roleDropdown.append($('<option></option>').attr(
								'value', role.roleID).text(role.roleName));
					});
				});
			});
</script>
<script>
	$(document).ready(
			function() {
				var managerDropdown = $("#Manager");

				$.get("ManagerServlet", function(data, status) {
					$.each(data, function(index, manager) {
						managerDropdown.append($('<option></option>').attr(
								'value', manager.mgrID).text(manager.mgrName));
					});
				});
			});
</script>
			
			
			<tr>
				<td><input type="submit" name="submit" value="Register" ></td>
			
			   <td><input type="reset" name="reset" value="Reset" ></td>
			</tr>
 

		</table>


	</form>
</section>
</body>
</html>