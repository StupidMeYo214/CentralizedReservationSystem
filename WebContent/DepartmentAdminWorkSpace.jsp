<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.models.GetDepartment"%>
<%@page import="com.utdallas.classes.Department"%>
<%@page import="com.utdallas.classes.Facility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.utdallas.classes.User"%>
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
String department = request.getParameter("department");
User user = (User)request.getAttribute("user");
ArrayList<Facility> facilityList = (ArrayList<Facility>)request.getAttribute("facilityList");
%>
<title><%=department %> Department Administration System</title>
</head>

<body>

    <div class="container">
  <h1>Welcome! <%=department %> Administrator <%=user.getName() %>!</h1>

  <ul>
    <p> As the Administrator of <%=department %> Staff, You Can :</p>
    <li>Add Resource.</li>
    <li>Delete Resource.</li>
    <li>Edit Resource.</li>
    <li>Edit Reservations</li>
  </ul>

  <div id="table" class="table-editable">
    <a class="table-add glyphicon glyphicon-plus" data-toggle="tooltip" data-placement="top" title="Add Facility" href="CreateFacilityUI.jsp?username=<%=user.getUserName()%>&dpt=<%=department %>&dptId=<%=user.getDepartID()%>"></a>
    <table class="table">
      <tr>

        <th>Department</th>
        <th>Resource</th>
		<th>Delete</th>
		<th>Edit</th>
		<th>Update Availability</th>

      </tr>

<%
	for(int i = 0; i < facilityList.size(); i++){
		Facility facility = facilityList.get(i);
		%>
		<tr>
			<td contenteditable="true"><%=facility.getDpt() %></td>
			<td>
			<a href="/CentralizedOnlineReservationSystem/DptAdminGetReservations?username=<%=user.getUserName() %>&departmentName=<%=department %>&facilityId=<%=facility.getFacilityID() %>"><%=facility.getFacilityName() %></a></td>
			<td>
				<form action="/CentralizedOnlineReservationSystem/FacilityController" method="get">
					<input type="hidden" value="remove" name="task"></input>
					<input type="hidden" value="<%=user.getUserName() %>" name="username"></input>
					<input type="hidden" value="<%=department %>" name="dpt"></input>
					<input type="hidden" value="<%=facility.getFacilityID() %>" name="facilityId"></input>
					<button onclick="window.confirm('Remove Facility <%=facility.getFacilityName() %>')" class="table-remove glyphicon glyphicon-remove" data-toggle="tooltip" data-placement="top" title="Remove <%=facility.getFacilityName() %>" ></button>
				</form>
          		
        	</td>
        	<td>
          		<a href="EditFacilityUI.jsp?username=<%=user.getUserName()%>&dpt=<%=department %>&facilityId=<%=facility.getFacilityID()%>&oldName=<%=facility.getFacilityName() %>&oldDescription=<%=facility.getDescription() %>" class="table-up glyphicon glyphicon-repeat" data-toggle="tooltip" data-placement="top" title="Edit <%=facility.getFacilityName() %>"></a>
        	</td>
        	<td>
        		<a href="/CentralizedOnlineReservationSystem/FacilityController?task=update&username=<%=user.getUserName() %>&dpt=<%=department %>&facilityId=<%=facility.getFacilityID() %>" class="table-up glyphicon glyphicon-time" data-toggle="tooltip" data-placement="top" title="Edit <%=facility.getFacilityName() %>"></a>
        	</td>
		</tr>
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
