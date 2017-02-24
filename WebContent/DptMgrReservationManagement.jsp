<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.classes.ReservedRecord"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style1.css">
<%
String username = request.getParameter("username");
String departmentName = request.getParameter("departmentName");
String facilityId = request.getParameter("facilityId");
ArrayList<ReservedRecord> records = (ArrayList<ReservedRecord>)request.getAttribute("records");
%>
<title>Reservation Management</title>
</head>
<body>
<div class="container">
  <h1>Reservations Available to Modify</h1>
  <p> Click 'Remove' Button to Cancel Reservation</p>
	<p> Click 'Add' Button to Start Reservation</p>	
  <ul>

  </ul>

  <div id="table" class="table-editable">
    <button class="table-add glyphicon glyphicon-hand-left" data-toggle="tooltip" data-placement="top" title="Go Back" onclick="window.history.back();"></button>
    <table class="table">
      <tr>
        <th>User</th>
        <th>Department</th>
        <th>Resource</th>
        <th>Date</th>
        <th>Time-Slot</th>
        <th>Cancel</th>
        <th>Edit</th>
      </tr>
      <%
      for (int i = 0; i < records.size(); i++){
    	  ReservedRecord record = records.get(i);
    	  String username1 = record.getUsrname();
    	  String department = record.getDepartment();
    	  String facility = record.getfacility_name();
    	  String facilityId1 = record.getFacility_id();
    	  String reservationId = record.getReservation_id();
    	  String date = record.getDate();
    	  String timeslot = record.getTimeslot();
    %>
    	      <tr>
        <td contenteditable="true"><%=username1 %></td>
        <td contenteditable="true"><%=department %></td>
        <td contenteditable="true"><%=facility %></td>
        <td contenteditable="true"><%=date %></td>
        <td contenteditable="true"><%=timeslot %></td>
        <td>
         <a class="table-remove glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="top" title="Cancel" href="/CentralizedOnlineReservationSystem//DptAdminManageReservations?task=cancel&departmentName=<%=department %>&facilityId=<%=facilityId %>&reservationId=<%=reservationId %>&username=<%=username%>"></a>
        </td>
        <td>
         <a class="table-remove glyphicon glyphicon-edit" data-toggle="tooltip" data-placement="top" title="Edit" href="ReservationEditor.jsp?username=<%=username %>&facilityId=<%=facilityId %>&reservationId=<%=reservationId %>&departmentName=<%=department %>&resourceName=<%=facility %>&date=<%=date %>&timeSlot=<%=timeslot%>"></a>
        </td>
    <% 
      }
      %>


    </table>
  </div>

  
  <p id="export"></p>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'></script>
<script src='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.6.0/underscore.js'></script>

        <script src="js/index.js"></script>



  </body>
</html>