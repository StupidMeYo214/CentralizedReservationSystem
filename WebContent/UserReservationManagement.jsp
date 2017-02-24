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
//GetReservationByUser getReservationByUser = new GetReservationByUser();
//ArrayList<ReservedRecord> records=getReservationByUser.getReserveList("hxy123");
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
    <a class="table-add glyphicon glyphicon-plus" data-toggle="tooltip" data-placement="top" title="Go Back to Make New Reservation" href="/CentralizedOnlineReservationSystem/ShowDepartments?username=<%=username%>"></a>
    <table class="table">
      <tr>
        <th>Name</th>
        <th>Department</th>
        <th>Resource</th>
        <th>Date</th>
        <th>Time-Slot</th>
        <th>Cancel</th>
      </tr>
      <%
      for (int i = 0; i < records.size(); i++){
    	  ReservedRecord record = records.get(i);
    	  String username1 = record.getUsrname();
    	  String department = record.getDepartment();
    	  String facility = record.getfacility_name();
    	  String facilityId = record.getFacility_id();
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
         <a class="table-remove glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="top" title="Cancel Reservation" href="/CentralizedOnlineReservationSystem/ReservationCancelation?departmentName=<%=department %>&facilityId=<%=facilityId %>&reservationId=<%=reservationId %>&username=<%=username1%>"></a>
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
