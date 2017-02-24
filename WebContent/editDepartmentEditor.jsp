<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
String username = request.getParameter("username");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Department</title>
<%
String departmentName = request.getParameter("departmentName");
String departmentAddress = request.getParameter("address");
String contactEmail = request.getParameter("email");
String contactPhone = request.getParameter("phone");
String img = request.getParameter("img");
String departmentId = request.getParameter("departmentId");
%>
</head>
<body>

	<form action="/CentralizedOnlineReservationSystem/DepartmentController" method="get">
		<input type="hidden" name="username" value="<%=username%>"></input>
		<input type="hidden" name="departmentId" value="<%=departmentId%>"></input>
		<input type="hidden" name="task" value="edit"/>
		<table border="1" align="center">
			<tr><td>Department Name</td> <td><%=departmentName %></td></tr>
			<tr><td>Address</td> <td><input name="departmentAddress" value="<%=departmentAddress %>"/></td></tr>
			<tr><td>Email</td> <td><input name="contactEmail" value="<%=contactEmail %>"/></td></tr>
			<tr><td>Phone</td> <td><input name="contactPhone" value="<%=contactPhone %>"/></td></tr>
			<tr><td>Image</td> <td><input type="file" name="img" value="<%=img %>"/></td></tr>
			<tr><td><input type="submit" value="OK"></input></td> <td></td></tr>
		</table>
	</form>

</body>
</html>