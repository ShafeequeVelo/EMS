<%@page import="com.velociter.ems.pojo.RegistrationPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

response.setHeader("Pragma", "no-cache"); // HTTP 1.0.

response.setDateHeader("Expires", 0);

String empid = session.getAttribute("empID").toString();

 

if (null == session.getAttribute("empID")) {

     response.sendRedirect("ControllerServlet?submit=logoutServlet");

} else {

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Update Employee</title>

</head>

<body>

     <jsp:include page="Header.jsp" />

     <h1>Change Password</h1>

     <div class="content">

           <form action="ControllerServlet" method="post">

           <input type="hidden" name="empid" value="<% out.print(session.getAttribute("empID")); %>">

           <table align="center" border="2px">

                <tr>

                     <td>

                           <%

                           out.print(session.getAttribute("fName") + " " + session.getAttribute("lName") );

                           %>

                     </td>

                </tr>

                     <tr>

     <td>Password<Span style="color: red">*</Span>:

     </td>

     <td><input type="password" id="password" name="Password"

           pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})[a-zA-Z0-9!@#\$%\^&\*]+$"

           title="Password must contain at least one uppercase letter, one lowercase letter, one number, one special character, and be at least 8 characters long"

           required oninput="checkPasswordMatch()"></td>

</tr>

<tr>

     <td>Confirm Password<Span style="color: red">*</Span>:

     </td>

     <td><input type="password" id="confirmPassword"

           name="ConfirmPassword"

           pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})[a-zA-Z0-9!@#\$%\^&\*]+$"

           title="Password doesn't Match" required onkeyup="checkPasswordMatch()"></td>

</tr>

 

                     <tr>

                     <td colspan="3" align="center"><input type="submit" class="submit"

                           name="submit" value="UpdatePassword"> </td>

                </tr>

 

           </table>

           </form>

     </div>

</body>

</html>

<%

}

%>