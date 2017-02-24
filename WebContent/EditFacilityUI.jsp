<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.classes.Facility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Facility Editor</title>
<%
String task="edit";
String username=request.getParameter("username");
String dpt = request.getParameter("dpt");
String facilityId = request.getParameter("facilityId");
String oldName = request.getParameter("oldName");
String oldDescription = request.getParameter("oldDescription");
%>
</head>
<body>
<form action="/CentralizedOnlineReservationSystem/FacilityController" method="get">
	<h1>Edit <%=oldName %></h1><br>
	<p>Description: </p>
	<br>
	<p><%=oldDescription%></p>
	<table border="1" align="center">
		<tr><td>Facility Name</td><td><input name="newName"></input></td></tr>
		<tr><td>Facility Description</td><td><input name="newDescription"/></td></tr>
		<input type="hidden" name="task" value="<%=task%>"></input>
		<input type="hidden" name="username" value="<%=username %>"></input>
		<input type="hidden" name="dpt" value="<%=dpt%>"></input>
		<input type="hidden" name="facilityId" value="<%=facilityId%>"></input>

		<tr><td><input type="submit" value="Modify" onclick="window.alert('Are You Sure to Modify This Facility Info?');"/></td><td></td></tr>
	</table>

</form>
</body>
</html>