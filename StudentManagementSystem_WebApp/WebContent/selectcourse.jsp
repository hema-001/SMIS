<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Self select course form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">

body
{
	margin:0px;
	background:lightgray;
	background-image: url("img/Capture.PNG");
	background-size: 100% 100%;
	background-attachment: fixed;
}

header
{
	height:60px;
	background: dodgerblue;
	margin-bottom:50px;
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
	background:dodgerblue;
	border-radius:3px;
	float:right;
	margin:18px;
	color:white;
	font-size:17px;
}

.container
{
	margin:0px auto;
	width:90%;
	background:white;
	padding:10px;
}

.form1
{
	margin:0px auto;
	width:90%;
	padding:5px;
	background:lightblue;
	text-align:center;
}

.form1 input
{
	width:60%;
	border-radius:3px;
	border:1px solid dodgerblue;
	padding-left:10px;
}

.form1 button
{
	background:royalblue;
	color:white;
	border:none;
	font-size:15px;
	padding:2px;
	padding-left:10px;
	padding-right:10px;
}


footer
{
	height:30px;
	background:dodgerblue;
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
<h4><i class='fas fa-chalkboard-teacher'></i>Choosing Courses</h4>
<button onClick="window.location='login.jsp';">log out</button>
<button onclick="window.location='home.jsp';">Home</button>
</header>


<div class="container">
<div class="row">
<div class="col-md-12">

<form action="/StudentManagementSystem/Controller" method="post" class="form1">
<input type="hidden" name="page" value="course-search-form">
<input type="hidden" name="id" value="${ id}">
<input type="text" name="subject" placeholder="Please enter the course number for inquiry!" required>
<button>Search</button>
</form>


</div>
</div>
</div>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>