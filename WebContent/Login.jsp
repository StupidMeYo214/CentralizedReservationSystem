<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta charset="UTF-8"></meta>
<link rel="stylesheet" href="css/reset.css"></link>
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'></link>
<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'></link>
<link rel="stylesheet" href="css/style.css"></link>

<title>Login Page</title>

<script language="javascript">
	
<!--
function checkInput(){
	
	if(login.userNameIn.value == "" && login.passwordIn.value != ""){
		window.alert("User Name Cannot Be Empty!");
		return false;
	}
	else if(login.userNameIn.value != "" && login.passwordIn.value == ""){
		window.alert("Password Cannot Be Empty!");
		return false;
	}
	else if(login.userNameIn.value == "" && login.passwordIn.value == ""){
		window.alert("Please Enter User Name and Password");
		return false;
	}
}
-->	

</script>

</head>

  <body>


<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Centralized Reservation System Login</h1>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">FeedBack</div>
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form id="form1" name="login" method="post" action="/CentralizedOnlineReservationSystem/Verification">
      <input type="text" name="userNameIn" placeholder="Username"/>
      <input type="password" name="passwordIn" placeholder="Password"/>
      <button onclick="return checkInput();" >Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Feedback</h2>
    <form>
      <input type="text" placeholder="Username"/>
      <input type="password" placeholder="University ID"/>
      <input type="email" placeholder="Feedback"/>
      <input type="tel" placeholder="Phone Number"/>
      <button>Submit</button>
    </form>
  </div>
  <div class="cta"><a href="https://netid.utdallas.edu/">Forgot your password?</a></div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='material.js'></script>

        <script src="js/index.js"></script>



  </body>
</html>