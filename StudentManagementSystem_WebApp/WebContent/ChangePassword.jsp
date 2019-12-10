<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>

<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">

body
{
	
	background-image:url('img/university.png');
	background-attachment: fixed;
	background-size:100% 100%;
	margin: 0px;
	
}

header
{
	height:60px;
	background:forestgreen;
}

header i
{
	margin-right:20px;
	font-size:24px;
}

header h4
{
	color:white;
	margin:18px;
	display:inline-block;
}

header button
{
	border:1px solid white;
	background:forestgreen;
	border-radius:3px;
	float:right;
	margin:18px;
	color:white;
	font-size:17px;
}

form
{
	margin:150px;
	text-align:center;
}

table
{
	margin:0px auto;
}

input
{
	border-radius: 5px;
}

footer
{
	height:30px;
	background:forestgreen;
	color:white;
	text-align:center;
	padding:5px;
	left: 0;
  	bottom: 0;
	position:fixed;
  	width:100%;
}

</style>

</head>
<body>

<header>
<h4><i class='fas fa-chalkboard-teacher'></i>Update Password</h4>
<button onClick="window.location='login.jsp';">log out</button>
<button onclick="window.location='home.jsp';">Home</button>
</header>

<form action="/StudentManagementSystem/Controller" method="post">

<input type="hidden" name="page" value="change-password-form">
<input type="hidden" name="id" value="${ id}">

<table>
<tr>
<td>
Old Password:
</td>
</tr>

<tr>
<td>
<input type="password" name="oldpassword" required>
</td>
</tr>

<tr>
<td>
New Password:
</td>
</tr>

<tr>
<td>
<input type="password" name="newpassword1" required>
</td>
</tr>

<tr>
<td>
Confirm Password:
</td>
</tr>

<tr>
<td>
<input type="password" name="newpassword2" required>
</td>
</tr>

<tr>
<td style="color:red; text-align:center"><c:out value="${ msg}"></c:out></td>
</tr>

</table>

<br>
<input type="submit" value="change">

</form>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>