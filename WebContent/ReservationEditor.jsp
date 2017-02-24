<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Reservation Editor</title>
<%
	String username = request.getParameter("username");
	String task = "edit";
	String departmentName = request.getParameter("departmentName");
	String facilityId = request.getParameter("facilityId");
	String reservationId = request.getParameter("reservationId");
	String resourceName=request.getParameter("resourceName");
	String date = request.getParameter("date");
	String timeSlot=request.getParameter("timeSlot");
%>
</head>
<body>
	
	<form method="post" action="/CentralizedOnlineReservationSystem/DptAdminManageReservations?username=<%=username%>&task=<%=task%>&departmentName=<%=departmentName%>&facilityId=<%=facilityId%>&reservationId=<%=reservationId%>">
	<table>
		<tr><td>Department</td><td><%=departmentName %></td></tr>
		<tr><td>Resource Name</td><td><%=resourceName %></td></tr>
		<tr><td>Date</td><td><%=date %></td></tr>
		<tr><td>Time Slot</td><td><%=timeSlot %></td></tr>
		<tr><td>New User</td><td><input name="usernameNew"></input></td></tr>
		<tr><td></td><td><button>Submit</button></td></tr>
	</table>
	</form>
	
</body>
</html>