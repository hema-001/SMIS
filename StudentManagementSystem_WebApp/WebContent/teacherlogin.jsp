<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher Login</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">

body
{
	margin:0px;
}

header
{
	height:60px;
	background:dodgerblue;
	margin-bottom:20px;
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


.container
{
	margin:0px auto;
	width:80%;
	border:2px solid lightgray;
	background:lightgray;
	border-radius:3px;
	background-image: url("img/Capture2.PNG");
	background-size: 100% 100%;
	height:500px;
}

.col-md-3
{
	background:white;
	padding-right:10px;
	margin:0px auto;
	width:23%;
	margin-top:20px;
}

table input
{
	width:180px; 
	border-radius:3px;
	margin-top:10px;
}

footer
{
	height:30px;
	background:goldenrod;
	color:white;
	text-align:center;
	padding:5px;
  	left: 0;
  	bottom: 0;
  	width:100%;
  	position:fixed;
}

</style>

</head>
<body>

<header>
<h4><i class='fas fa-chalkboard-teacher'></i>Teaching integrated information service platform</h4>
</header>

<div class="container">
<div class="row">

<div class="col-md-9">

</div>

<div class="col-md-3">

<div style="margin:20px;">

<h4><b>Teacher login</b></h4>

<form action="/StudentManagementSystem/Controller" method="post">
<input type="hidden" name="page" value="teacher-login-form">

<table style="margin:0px auto">

<tr>
<td>
<input type="text" name="id" required>
</td>
</tr>

<tr>
<td>
<input type="password" name="password" required>
</td>
</tr>

<tr>
<td>
<input type="submit" value="log in" style="background:dodgerblue; border:none; color:white">
</td>
</tr>

<tr>
<td style="text-align:center">
<a href="Controller?page=student-login" style="color:dodgerblue;">Student login</a>
</td>
</tr>

<tr>
<td style="color:red; text-align:center"><c:out value="${ msg}"></c:out></td>
</tr>

</table>

</form>

</div>

</div>

</div>
</div>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>