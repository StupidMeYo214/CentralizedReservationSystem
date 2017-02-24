<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Create User</title>
<%
String username = request.getParameter("username");
String department = request.getParameter("department");
String departmentId = request.getParameter("departmentId");
%>
</head>
<body>
	
	<form action="/CentralizedOnlineReservationSystem/DepartmentController" method="get">
	<input type="hidden" name="username" value="<%=username%>"></input>
	<input type="hidden" name="department" value="<%=department%>"></input>
	<input type="hidden" name="departmentId" value="<%=departmentId%>"></input>
	<input type="hidden" name="task" value="newUser"/>
		<table border="1" align="center">
			<tr><td>Name</td> <td><input name="name"/></td></tr>
			<tr><td>User Name</td> <td><input name="newUsername"/></td></tr>
			<tr><td>Password</td> <td><input name="password"/></td></tr>
			<tr><td>email</td> <td><input name="email"/></td></tr>
			<tr><td>address</td> <td><input name="address"/></td></tr>
			<tr><td>Set User As</td> 
				<td>
					<select name="level">
					  <option value="3">Student</option>
					  <option value="2">Staff</option>
					</select>
				</td>
			</tr>
			<tr><td><input type="submit" value="OK"></input></td><td></td></tr>
		</table>
	</form>

</body>
</html>