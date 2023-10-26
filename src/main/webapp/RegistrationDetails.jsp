<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Details</title>
</head>
<body>
<%
String name = request.getAttribute("Name").toString();
out.println(name);
String empID = request.getAttribute("empID").toString();
out.println(empID);
int age = Integer.parseInt(request.getParameter("age"));
out.println(age);
String gender = request.getParameter("gender").toString();
out.println(gender);
String address = request.getAttribute("address").toString();
out.println(address);
String email = request.getParameter("email").toString();
out.println(email);
String password = request.getParameter("password").toString();
out.println(password);

%>

</body>
</html>