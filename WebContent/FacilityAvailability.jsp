<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.models.GetDateString"%>
<%@page import="com.utdallas.classes.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
//detect reservation times is exceed or not
String timesLimit = request.getParameter("timesLimit");
String department = (String)request.getAttribute("department");
String facilityId = (String)request.getAttribute("facilityId");
String date1 = (String)request.getAttribute("date");
String facility = (String)request.getAttribute("facility");
String username = request.getParameter("username");
ArrayList<Reservation> reservations = (ArrayList<Reservation>)request.getAttribute("reservations"); %>
<meta charset="UTF-8">
<title>Check Availability of <%=department %> <%=facility %></title>
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style1.css">

</head>
  <body>

    <div class="container">
  <h1>Schedules for <%=facility.toUpperCase() %> [<%=department %>] on <%=date1 %></h1>
  <p> You can make reservations by clicking add button.</p>
  <p><%=username %></p>
  <ul>

    <li>
		<p>Check More Date</p>
		<form method="post" action="/CentralizedOnlineReservationSystem/FacilityAvailability?username=<%=username%>&departmentName=<%=department %>&facilityId=<%=facilityId%>&facility=<%=facility %>">
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
				<button>Check </button>
				</td></tr>
			</table>
	</li>
    <li><a href="/CentralizedOnlineReservationSystem/UserManageReservation?username=<%=username%>">Manage My Reservations</a></li>

  </ul>

  <div id="table" class="table-editable">

    <table class="table">
      <tr>
        <th>Date</th>
        <th>TimeSlot</th>
        <th>Availability</th>
		<th>Reserve</th>
      </tr>
	  
	  <%for (int i = 0; i < reservations.size(); i++){
		Reservation temp = reservations.get(i);
		String date = temp.getDate();
		String reservationId = temp.getReservationId();
		String timeslot = temp.getTimeslot();
		String reserved = temp.getReserved();
		String username1 = temp.getUsername();
		%>
		<tr>
			<td contenteditable="true"><%=date %></td>
			<td contenteditable="true"><%=timeslot %></td>
			<td contenteditable="true">Available</td>
			<td>
			
				<a id="makeres" type="submit" href="/CentralizedOnlineReservationSystem/UserReserve?date=<%=date%>&facility=<%=facility%>&departmentName=<%=department%>&facilityId=<%=facilityId%>&reservationId=<%=reservationId%>&username=<%=username%>"  >+</a>
			
          
			</td>
		</tr>
		<%
	} %>

    </table>
  </div>


  <p id="export"></p>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js'></script>

        <script src="js/index1.js"></script>



  </body>
  <%
 if(timesLimit!=null && timesLimit.equals("1")){
	 %>
	 <script>window.alert("Sorry! You Have Already Reserved 2 Timeslots of This Resource on The Same Day!");</script>
	 
	 <%
 }
%>
</html>