<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.utdallas.classes.Department"%>
<%@page import="com.utdallas.classes.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
  <head>
<meta charset="UTF-8">
<title>System Admin Workspace</title>
<link rel='stylesheet prefetch' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style1.css">
<%
User user = (User)request.getAttribute("user");
ArrayList<Department> departmentList = (ArrayList<Department>)request.getAttribute("departments");
%>
</head>

  <body>

    <div class="container">
  <h1>Hello <%=user.getName() %>!</h1>
  <p> As a system administrator, you can:</p>

  <ul>
    <li>Add Department</li>
    <li>Delete Department</li>
    <li>Edit Department</li>
    <li>Create User for Department</li>
  </ul>

  <div id="table" class="table-editable">
    <a href="addDepartmentEditor.jsp?username=<%=user.getUserName() %>" class="table-add glyphicon glyphicon-plus" title="add department"></a>
    <table class="table">
      <tr>

        <th>Department Name</th>
        <th>Department Adress</th>
		<th>Contact Number</th>
		<th>Email</th>
		<th>remove</th>
		<th>edit</th>
		<th>add user</th>

      </tr>
      
      <%
      	for (int i = 0; i < departmentList.size(); i++){
      		Department department = departmentList.get(i);
      		String departmentName = department.getDepartmentName();
      		String departmentAdress = department.getDepartmentAddress();
      		String departmentId = department.getDepartmentID();
      		String email = department.getContactEmail();
      		String phone = department.getContactPhone();
      		String img = department.getImg();
      		%>
      		
            <tr>
            <td contenteditable="true"><%=departmentName %></td>
            <td contenteditable="true"><%=departmentAdress %></td>
    		<td contenteditable="true"><%=phone %></td>
    		<td contenteditable="true"><%=email %></td>
            <td>
              <a href="/CentralizedOnlineReservationSystem/DepartmentController?task=remove&username=<%=user.getUserName() %>&departmentId=<%=departmentId %>&departmentName=<%=departmentName %>" class="table-remove glyphicon glyphicon-remove" title="delete department"></a>
            </td>
    		<td>
              <a href="editDepartmentEditor.jsp?departmentId=<%=departmentId %>&username=<%=user.getUserName() %>&departmentName=<%=departmentName %>&address=<%=departmentAdress %>&email=<%=email %>&phone=<%=phone %>&img=<%=img %>" class="table-up glyphicon glyphicon-repeat" title="edit department"></a>
    		</td>
            <td>
              <a href="newUserEditor.jsp?username=<%=user.getUserName() %>&department=<%=departmentName %>&departmentId=<%=departmentId %>" class="table-down glyphicon glyphicon-user" title="create user"></a>
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