<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<style>
.logout-button {
	background-image: url('power-button.png');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	width: 60px;
	color: green;
	height: 40px;
	border: none;
	text-indent: -9999px;
	cursor: pointer;
}

.logout-button-text {
	opacity: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left:450px;
	transform: translate(-50%, -50%);
	transition: opacity 0.3s;
}

.logout-button:hover .logout-button-text {
	opacity: 1;
}
</style>

	<form action="ControllerServlet" method="post">
		<div class="logout-button">
			<input type="submit" name="submit" value="Logout"
				class="logout-button"> <span class="logout-button-text">Logout</span>
		</div>
	</form>
</body>
</html>