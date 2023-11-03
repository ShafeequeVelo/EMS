<%@page import="com.velociter.ems.pojo.StatePojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 10px; /* Decrease padding to reduce overall spacing */
    }

    h3 {
        text-align: center;
        margin-bottom: 2px; /* Reduce bottom margin */
    }

    table {
        //margin: 5px auto; /* Adjust table margin */
        margin-top : -15px;
        width: 100%;
    }

    table td {
        padding: 6px; /* Slightly reduce cell padding */
    }

    input[type="text"],
    input[type="number"],
    input[type="email"],
    input[type="password"],
    input[type="submit"],
    input[type="reset"],
    input[type="radio"],
    select {
        width: calc(100% - 20px);
        padding: 8px; /* Adjust input padding */
        margin: 3px 0; /* Reduce input margin */
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="radio"],
    select {
        width: auto;
        margin-right: 6px; /* Reduce right margin for radio buttons and selects */
    }

    input[type="submit"],
    input[type="reset"],
    input[type="button"] {
        width: 40%;
        padding: 2px; /* Decrease button padding */
        margin: 2px 0; /* Adjust button margin */
        border: 5;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:not([value='Login Now']),
    input[type="reset"],
    input[type="button"] {
        padding: 4px; /* Decrease padding for non-login buttons */
        background-color: #4CAF50;
        color: white;
    }

    input[type="submit"]:not([value='Login Now']):hover,
    input[type="reset"]:hover,
    input[type="button"]:hover {
        background-color: #45a049;
    }

    input[type="submit"][value='Login Now'],
    input[type="button"] {
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
        border: none;
        border-radius: 5px;
        padding: 2px; /* Decrease padding for login button */
    }

    input[type="submit"][value='Login Now']:hover,
    input[type="button"]:hover {
        background-color: #45a049;
    }
</style>

</script>
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
<script>
	function checkPasswordMatch() {
		var password = document.getElementById("password");
		var confirmPassword = document.getElementById("confirmPassword");

		if (password.value !== confirmPassword.value) {
			confirmPassword.setCustomValidity("Passwords don't match");
		} else {
			confirmPassword.setCustomValidity("");
		}
	}

	window.onload = function() {
		var confirmPassword = document.getElementById("confirmPassword");
		confirmPassword.onkeyup = checkPasswordMatch;
	};
</script>
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
	<h3 align="center">Registration Page</h3>
	<form action="ControllerServlet" method="post">
		<table align="center">

			<tr>
				<td>
					<table>

						<tr>
							<td>First Name <span style="color: red">*</span></td>
							<td><input type="text" name="fName"
								oninput="this.value = 
				this.value.replace(/[^a-zA-Z]/g, '')"
								required></td>
						</tr>
						<tr>
							<td>Last Name <span style="color: red">*</span></td>
							<td><input type="text" name="lName"
								oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')"
								required></td>
						</tr>
						<tr>
							<td>EmpID <span style="color: red">*</span></td>
							<td><input type="text" name="empid" required="required"
								pattern="[a-zA-Z0-9]+"></td>
						</tr>
						<tr>
							<td>Age <span style="color: red">*</span></td>
							<td><input type="number" name="age" min="1" max="100"
								oninput="this.value = this.value.replace(/[^0-9]/g, ''); limitInputLength(this,2)"></td>
						</tr>
						<tr>
							<td colspan="1">Gender <span style="color: red">*</span></td>
							<td><input type="radio" name="gender" value="Male">Male
								<input type="radio" name="gender" value="Female">Female
								<input type="radio" name="gender" value="others"> Others
							</td>
						</tr>

						<tr>
							<td>Phone <span style="color: red">*</span></td>
							<td><input type="text" id="Phone" name="phone" 
							pattern="[0-9]{10}" title="Please Enter 10 digits Phone Number" 
							required maxlength="10" oninput="this.value=this.value.replace(/[^0-9]/g,'');"></td>
						</tr>
						<tr>
							<td>Email <span style="color: red">*</span></td>
							<td><input type="email" name="email" required="required"></td>
						</tr>
						<tr>
							<td>Username <span style="color: red">*</span></td>
							<td><input type="text" name="uName" required="required"
								pattern="[a-zA-Z0-9]+"></td>
						</tr>
					
				<!--		<tr>
							<td>Password<span style="color: red">*</span></td>
							<td><input type="password" id="password" name="password"
							pattern=".{8,}" title="Password must be at least 8 characters long"
								required="required" maxlength="8"></td>
						</tr> -->
						
						<tr>
    <td>Password<span style="color: red">*</span></td>
    <td><input type="password" id="password" name="password" 
        pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})[a-zA-Z0-9!@#\$%\^&\*]+$" 
        title="Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 8 characters long" 
        required="required" maxlength="20"></td>
</tr>
						
				<!--	<tr>
							<td>Confirm Password<span style="color: red">*</span></td>
							<td><input type="password" id="confirmPassword"
								name="confirmPassword" required="required" maxlength="8"></td>
						</tr>  -->
						
						<tr>
    <td>Confirm Password<span style="color: red">*</span></td>
    <td><input type="password" id="confirmPassword" name="confirmPassword" 
        pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})[a-zA-Z0-9!@#\$%\^&\*]+$" 
        required="required" maxlength="20"></td>
</tr>
						
					</table>
				</td>

				<td colspan="2"><jsp:include page="Address.jsp"></jsp:include></td>
				<td>
					<table align="center">
						<tr>
							<td>Department<span style="color: red">*</span></td>
							<td><select name="DepartmentID" id="Department"
								required="required">
									<option value="">Select</option>
							</select></td>
						</tr>
						<tr>
							<td>Role<span style="color: red">*</span></td>
							<td><select name="RoleID" id="Role" required="required">
									<option value="">Select</option>
							</select></td>
						</tr>
						<tr>
							<td>Managers</td>
							<td><select name="ManagerID" id="Manager">
									<option value="">Select</option>
							</select></td>
						</tr>
					</table>

				</td>
			</tr>

			<tr>
				<td><input type="submit" name="submit" value="Register"><input type="reset" name="reset" value="Reset"></td>
			</tr>

		</table>

		<div class="note">
			<p>
				<strong>Note:</strong> Fields marked with a red asterisk (<span
					style="color: red">*</span>) are mandatory.
			</p>
		</div>

	</form>

	<form action="ControllerServlet" method="post">
	<!-- <table align="center">
			<tr>
				<td><input type="submit" name="submit" value="Login Now"></td>
			</tr>
		</table> -->
	</form>
</body>
</html>