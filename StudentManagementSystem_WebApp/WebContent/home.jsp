<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">

body
{
	margin:0px;
	background-image:url('img/university.png');
	background-attachment: fixed;
	background-size:100% 100%;
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

.dropbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  width:150px;
}


.dropdown {
  position: relative;
  display: inline-block;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}


.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}


.dropdown-content a:hover {background-color: #ddd;}


.dropdown:hover .dropdown-content {display: block;}


.dropdown:hover .dropbtn {background-color: #3e8e41;}

.container
{

	padding:10px;
	width:100%;
}

h4
{
	color:black;
	margin:20px;
	font-style:bold;
}

.table1
{
	margin:0px auto;
	margin-bottom:20px;
}

.table1 td
{
	width:120px;
	text-align:center;
	font-style:bold;
	color:black;
}

.table1 td i
{
	margin:20px;
	font-size:24px;
	color:white;
}

.selective
{
	background:palegreen;
	border-radius:50%;
	text-align: center;
	border:none;
	text-align:center;
	width:60px;
	height:60px;
}

.compulsory
{
	background:deeppink;
	border-radius:50%;
	text-align: center;
	border:none;
	margin:20px;
	width:60px;
	height:60px;
}

.notification
{
	background:royalblue;
	border-radius:50%;
	text-align: center;
	border:none;
	margin:20px;
	width:60px;
	height:60px;	
}

.inquiry
{
	background:orange;
	border-radius:50%;
	text-align: center;
	border:none;
	margin:20px;
	width:60px;
	height:60px;	
}

.curriculum
{
	margin-bottom:10px;
}

.curriculum .td1
{
	width:200px;
}

.curriculum .td2
{
	width:70px;
	text-align:center;
}

.notifications
{
	margin-bottom:10px;
}

.notifications .td1
{
	width:150px;
	height: 40px;
}

.notifications .td2
{
	width:130px;
	text-align:center;
	height: 40px;
}


hr
{
	border: 0.5px solid lightgray;
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
  	width:100%;
}

</style>
</head>
<body>

<header>
<h4><i class='fas fa-chalkboard-teacher'></i>Teaching integrated information service platform</h4>
<button onClick="window.location='login.jsp';">log out</button>
</header>

<div style="width:100%; text-align:center">

<div class="dropdown">
  <button class="dropbtn">Exam</button>
  <div class="dropdown-content">
    <a href="#">Make-Up Confirmation</a>
    <a href="#">Exam Schedule</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Information</button>
  <div class="dropdown-content">
    <a href="#">Information Maintenance</a>
    <a href="#">Guardian Information</a>
    <a href="Controller?page=change-password&id=${ id}">Change Password</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Course</button>
  <div class="dropdown-content">
    <a href="Controller?page=course-search&id=${ id}">Choosing Course</a>
    <a href="Controller?page=selected-courses&id=${ id}"">Course Schedule</a>
    <a href="#">TextBook Booking</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Evaluation</button>
  <div class="dropdown-content">
    <a href="#">Teaching Evaluation</a>
    <a href="#">Students Evaluation</a>
  </div>
</div>

<div class="dropdown">
  <button class="dropbtn">Project</button>
  <div class="dropdown-content">
    <a href="#">Education Project</a>
  </div>
</div>

</div>


<%-- 
<select>
<option>Make-Up Confirmation</option>
<option>Exam Schedule</option>
<option>Course Schedule</option>
</select>

<select name="info-maintain">
<option value="information-maintain"><a href="">Information Maintenance</a></option>
<option value="change-password">Change Password</option>
</select>


<select>

<option>Choosing Course</option>
<option>TextBook Booking</option>
</select>

<select>
<option>Information Query</option>
<option>Guardian Information</option>
</select>

<select>
<option>Teaching Evaluation</option>
<option>Students Evaluation</option>
</select>

<select>
<option>Education Project</option>
</select>

</nav>

--%>

<div class="container">
<div class="row">
<div class="col-md-3" style="background:white;">

<h4><b> My Applications </b></h4>

<hr>

<table class="table1">
<tr>
<td><input type="hidden" name="id" value="${ id}"></td>
</tr>
<tr>
<td><button class="selective" onClick="window.location='selectcourse.jsp';"><i class='fas fa-user-edit' style="margin:0px auto"></i></button></td>
<td><button class="compulsory" onclick="window.location='Courses.jsp';"><i class='fas fa-book-open' style="margin:0px auto"></i></button></td>
</tr>

<tr>
<td> Choose courses </td>
<td> Self-Selected courses </td>
</tr>

<tr>
<td><button class="inquiry"><i class='fas fa-edit' style="margin:0px auto"></i></button></td>
<td><button class="notification" onclick="window.location='Notifications.jsp';"> <i class='fas fa-envelope' style="margin:0px auto"></i></button></td>
</tr>

<tr>
<td>Student academic situation inquiry</td>
<td>Notifications storage</td>
</tr>

</table>

</div>

<div class="col-md-8" style="margin-left:10px">

<div class="row" style="background:white; margin-bottom:10px">

<div class="col-md-2" style="padding:10px">
<img alt="image not found" src="" width=100 height=120 style="border-radius:50%">
</div>

<div class="col-md-4" style="padding:10px">

<sql:setDataSource  url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db" />

<sql:query var="result1" dataSource="${ db}">
select * from student where id=${ id};
</sql:query>

<c:forEach items="${ result1.rows}" var="row">

<b><c:out value="${ row.name}"></c:out></b>
<h5><c:out value="${ row.college}"></c:out></h5>
<h5><c:out value="${ row.major}"></c:out></h5>
<h5><c:out value="${ row.email}"></c:out></h5>
</c:forEach>

</div>

</div>

<div class="row">
<div class="col-md-6" style="background:white; margin-right:75px; margin-bottom:10px">
<h4><b>Curriculum</b></h4>
 
<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result2" dataSource="${ db}">
select * from courses as c, select_course as sc where sc.course_code=c.course_code and sc.id=${ id};
</sql:query>

<table class="curriculum">
<c:forEach items="${ result2.rows}" var="row">

<tr>
<td class="td1"><c:out value="${ row.name}"></c:out> </td>
<td class="td2"><c:out value="${ row.day}"></c:out> </td>
<td class="td2"><c:out value="${ row.period}"></c:out> </td>
<td class="td2"><c:out value="${ row.room}"></c:out> </td>
</tr>

</c:forEach>
</table>

</div>



<div class="col-md-5" style="background:white">
<h4><b>School Calendar</b></h4>
</div>
</div>

<div class="row">
<div class="col-md-6" style="background:white; margin-right:75px">
<h4><b>Message Notification</b></h4>

<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result" dataSource="${ db}">
select  title, issue_date, author from notifications order by issue_date desc;
</sql:query>

<table class="notifications">
<c:forEach items="${ result.rows}" var="row">
<tr>
<td class="td1"><c:out value="${ row.issue_date}"></c:out> </td>
<td class="td2"><c:out value="${ row.author}"></c:out> </td>
<td class="td2"><c:out value="${ row.title}"></c:out> </td>
</tr>
</c:forEach>
</table>

</div>


<div class="col-md-5" style="background:white">
<h4><b>Score</b></h4>
</div>
</div>
</div>

</div>

</div>


<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>