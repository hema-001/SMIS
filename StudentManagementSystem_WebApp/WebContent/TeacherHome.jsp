<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teachers' Home Page</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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

.nav1
{
	height:50px;
	background:white;
}

option
{
	background:white;
}

select
{
	margin-left:15px;
	font-size:15px;
	height:50px;
	cursor:pointer;
	text-align:center;
	border: 1px solid transparent;
}

select:hover
{
	background:lightgray;
}

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
	position:fixed;
  	width:100%;
}

</style>
</head>
<body>

<header>
<h4><i class='fas fa-chalkboard-teacher'></i>Teaching integrated information service platform</h4>
<button onClick="window.location='teacherlogin.jsp';">log out</button>
</header>

<nav class="nav1">

<select>
<option>Apply for signing up</option>
<option>Make-Up Confirmation</option>

</select>

<select>
<option>Information Maintenance</option>
<option>Student guardian information collection</option>
<option>Personal Information Maintenance for Students</option>
<option>Registration for Student</option>
</select>

<select>
<option>Curricula-Variable</option>
<option>Course Schedule</option>
<option>Choosing Course</option>
<option>TextBook Booking</option>
</select>

<select>
<option>Information Query</option>
</select>

<select>
<option>Teaching Evaluation</option>
<option>Students Evaluvation</option>
</select>

<select>
<option>Education Project</option>
</select>

</nav>

<div class="container" style="">
<div class="row">
<div class="col-md-3" style="background:white;">

<h4><b> My Applications </b></h4>

<hr>

<table class="table1">
<tr>
<td><input type="hidden" name="id" value="${ id}"></td>
</tr>
<tr>
<td><button class="compulsory" onclick="window.location='TeachCourses.jsp';"><i class='fas fa-book-open' style="margin:0px auto"></i></button></td>
<td><button class="notification" onclick="window.location='TeacherNotification.jsp';"> <i class='fas fa-envelope' style="margin:0px auto"></i></button></td>
</tr>

<tr>
<td> Teaching courses </td>
<td>Notifications storage</td>
</tr>

<%-- 
<tr>
<td><button class="inquiry"><i class='fas fa-edit' style="margin:0px auto"></i></button></td>
<td><button class="selective" onClick="window.location='selectcourse.jsp';"><i class='fas fa-user-edit' style="margin:0px auto"></i></button></td>
</tr>


<tr>
<td>Student academic situation inquiry</td>
<td> Select courses </td>
</tr>
--%>

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
select * from teacher where id=${ id};
</sql:query>

<c:forEach items="${ result1.rows}" var="row">

<b><c:out value="${ row.name}"></c:out></b>
<h5><c:out value="${ row.college}"></c:out></h5>

</c:forEach>

</div>

</div>

<div class="row">
<div class="col-md-6" style="background:white; margin-right:75px; margin-bottom:10px">
<h4><b>Curriculum</b></h4>
 
<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result2" dataSource="${ db}">
select * from courses as c, teacher_select_course as sc where sc.course_code=c.course_code and sc.id=${ id};
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