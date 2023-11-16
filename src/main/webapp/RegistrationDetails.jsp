<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* Import Google font - Poppins */
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body {
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  background: rgb(130, 106, 251);
}
.container {
  position: relative;
  max-width: 700px;
  width: 100%;
  background: #fff;
  padding: 25px;
  border-radius: 8px;
  box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}
.container header {
  font-size: 1.5rem;
  color: #333;
  font-weight: 500;
  text-align: center;
}
.container .form {
  margin-top: 30px;
}
.form .input-box {
  width: 100%;
  margin-top: 20px;
}
.input-box label {
  color: #333;
}
.form :where(.input-box input, .select-box) {
  position: relative;
  height: 50px;
  width: 100%;
  outline: none;
  font-size: 1rem;
  color: #707070;
  margin-top: 8px;
  border: 1px solid #ddd;
  border-radius: 6px;
  padding: 0 15px;
}

.form .column {
  display: flex;
  column-gap: 15px;
}
.form .gender-box {
  margin-top: 20px;
}
.gender-box h3 {
  color: #333;
  font-size: 1rem;
  font-weight: 400;
  margin-bottom: 8px;
}
.form :where(.gender-option, .gender) {
  display: flex;
  align-items: center;
  column-gap: 50px;
  flex-wrap: wrap;
}
.form .gender {
  column-gap: 5px;
}
.gender input {
  accent-color: rgb(130, 106, 251);
}
.form :where(.gender input, .gender label) {
  cursor: pointer;
}
.gender label {
  color: #707070;
}
.address :where(input, .select-box) {
  margin-top: 15px;
}
.select-box select {
  height: 100%;
  width: 100%;
  outline: none;
  border: 50;
  color: #707070;
  font-size: 1rem;
}
.form button {
  height: 55px;
  width: 100%;
  color: #fff;
  font-size: 1rem;
  font-weight: 400;
  margin-top: 30px;
  border: none;
  cursor: pointer;
  transition: all 0.2s ease;
  background: rgb(130, 106, 251);
}
.form button:hover {
  background: rgb(88, 56, 250);
}

</style>
<meta charset="ISO-8859-1">
<title>Registration Details</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<section class="container">
		<header>Registration Form</header>
		<form action="ControllerServlet" class="form" method="post">
			<div class="input-box">
				<label>First Name</label> <input type="text" name="fName" oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')"
					placeholder="Enter your firstname" required />
			</div>
			<div class="input-box">
				<label>Last Name</label> <input type="text" name="lName" oninput="this.value = this.value.replace(/[^a-zA-Z]/g, '')"
					placeholder="Enter your lastname" required />
			</div>
			<div class="input-box">
				<label>EmpID</label> <input type="text" name="empid" oninput="this.value = this.value.replace(/[a-zA-Z0-9]+, '')"
					placeholder="Enter your empID" required />
			</div>
			<div class="input-box">
				<label>Age</label> <input type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="2"
					placeholder="Enter your age" required />
			</div>
			<div class="gender-box">
				<h3>Gender</h3>
				<div class="gender-option">
					<div class="gender">
						<input type="radio" id="check-male" name="gender" checked /> <label
							for="check-male">male</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-female" name="gender" /> <label
							for="check-female">Female</label>
					</div>
					<div class="gender">
						<input type="radio" id="check-other" name="gender" /> <label
							for="check-other">Other</label>
					</div>
				</div>
			</div>
			
				<div class="input-box">
					<label>Phone Number</label> <input type="text" name="phone" required="required" oninput="this.value = this.value.replace(/[^0-9.]/g, '')" maxlength="10"
						placeholder="Enter your phone number" required />
				</div>
			<div class="input-box">
				<label>Email</label> <input type="email" name="email"
					placeholder="Enter your email address" required />
			</div>
			<div class="input-box">
				<label>Username</label> <input type="text" name="uName" required="required" pattern="[a-zA-Z0-9]+"
					placeholder="Enter your Username" required />
			</div>
			<div class="input-box">
				<label>Password</label> <input type="password" id="password" required="required" maxlength="8"
					placeholder="Enter your password" required />
			</div>
				<div class="input-box">
				<label>Confirm Password</label> <input type="password" name="confirmpassword" id="confirmPassword" required="required" maxlength="8"
					placeholder="Enter your confirm password" required />
			</div>
			
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
				<td colspan="2"><jsp:include page="address2.jsp"></jsp:include></td>
			</tr>
			 <div class="select-box">
			<label>Department</label> 
			<select name="DepartmentID" id="Department" required="required">
				<option value="">Select</option>
				</select>
			</div>
			 <div class="select-box">
			
				<label>Role</label>
				<select name="RoleID" id="Role" required="required">
				<option value="">Select</option>
				</select>
		
			</div>
			 <div class="select-box">
				<td>Manager</td>
				<td><select name="ManagerID" id="Manager">
				<option value="">Select</option>
				</select></td>
		
			</div>
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
			<!-- 		
			<tr>
				<td><input type="submit" name="submit" value="Register" ></td>
			
			   <td><input type="reset" name="reset" value="Reset" ></td>
			   </tr>
			    -->
			   	 <button>Submit</button>
			   
			
 

		</table>


	</form>
</section>
</body>
</html>