<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.classes.Facility"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="assets/css/styles.css" />
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster" />
<%String departmentName=request.getParameter("departmentName");
String username = request.getParameter("username");
ArrayList<Facility> facilities = (ArrayList<Facility>)request.getAttribute("facilities"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Welcome to <%=departmentName %></title>
</head>

<body>


        <header>
            <h1>Welcome to <%=departmentName %></h1>

        </header>

        <h2>Resources List for The <%=departmentName %></h2>

        <nav>
            <ul class="fancyNav">
              
                <%for(int i=0; i<facilities.size(); i++){
					Facility temp = facilities.get(i);
					String facilityName = temp.getFacilityName();
					String facilityId = temp.getFacilityID();
					String description = temp.getDescription();
					//System.out.print(facilityName);
					%>
					 
					 <li id="services"><a href="FacilityDetail.jsp?username=<%=username %>&departmentName=<%=departmentName%>&facility=<%=facilityName %>&facilityId=<%=facilityId %>&description=<%=description %>"><%=facilityName %></a></li>
					 <%
				} %>


            </ul>
        </nav>
<br>
<a href="/CentralizedOnlineReservationSystem/UserManageReservation?username=<%=username%>">Manage My Reservations</a>
        
    </body>
</html>