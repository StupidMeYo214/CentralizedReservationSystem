<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.models.GetDateString"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String department = request.getParameter("departmentName");
String facility = request.getParameter("facility");
String description = request.getParameter("description");
String facilityId = request.getParameter("facilityId");
String username = request.getParameter("username");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>About <%=department.toUpperCase() %> <%=facility.toUpperCase() %></title>
<h1>What You Need to Know About: <%=department %> <%=facility %></h1>
<p><%=description %></p><br><br>


<p>Select Date:</p>

<form method="post" action="/CentralizedOnlineReservationSystem/FacilityAvailability?username=<%=username %>&departmentName=<%=department %>&facilityId=<%=facilityId%>&facility=<%=facility %>">
	<table border="1">
		<tr><td>
			<select name="date">
				<%for (int i = 0; i < 7; i++){
					String dateoption = GetDateString.getDateString(i);
					%>
					<option value="<%=dateoption %>"><%=dateoption %></option>
					<%
				} %>
			</select>
		</td><td>
		<button>Check Availability</button>
		</td></tr>
	</table>
</form>
<br>
<a href="/CentralizedOnlineReservationSystem/UserManageReservation?username=<%=username%>">Manage My Reservations</a>
</head>
<body>

</body>
</html>