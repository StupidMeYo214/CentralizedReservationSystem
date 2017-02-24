<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Facility Creation Page</title>
<%
String task="create";
String username=request.getParameter("username");
String dpt = request.getParameter("dpt");
String dptId = request.getParameter("dptId");
%>
</head>
<body>
<form action="/CentralizedOnlineReservationSystem/FacilityController" method="get">

	<table border="1" align="center">
		<tr><td>Facility Name</td><td><input name="facilityName"/></td></tr>
		<tr><td>Facility Description</td><td><input name="description"/></td></tr>
		<input type="hidden" name="task" value="create"></input>
		<input type="hidden" name="username" value="<%=username %>"></input>
		<input type="hidden" name="dpt" value="<%=dpt%>"></input>
		<input type="hidden" name="dptId" value="<%=dptId%>"></input>
		<tr><td><input type="submit" value="Create"/></td><td></td></tr>
	</table>

</form>
</body>
</html>