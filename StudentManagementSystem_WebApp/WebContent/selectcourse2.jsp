<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
    
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
	background:dodgerblue;
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
	width:100%;
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

th
{
	width:200px;
	height:50px;
	text-align:center;
	color:dodgerblue;
	border-bottom:1px solid royalblue;
}

td
{
	width:200px;
	text-align:center;
	height:50px;
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

<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result" dataSource="${ db}">
select * from courses where course_code=<%= request.getAttribute("subject") %>;
</sql:query>


<div class="row" style="margin-top:20px">
<div class="col-md-12" style="margin:0px auto; text-align:center">
<table>

<c:forEach items="${ result.rows}" var="row">

<tr>
<th>course code</th>
<th>name</th>
<th>Teacher</th>
<th>Credits</th>
<th>Semester</th>
<th>Week</th>
<th>Period</th>
<th>Room</th>
<th>Option</th>
</tr>


<tr>
<td><c:out value="${ row.course_code}"></c:out> </td>
<td><c:out value="${ row.name}"></c:out> </td>
<td><c:out value="${ row.teacher}"></c:out></td>
<td><c:out value="${ row.credits}"></c:out> </td>
<td><c:out value="${ row.semester}"></c:out> </td>
<td><c:out value="${ row.day}"></c:out> </td>
<td><c:out value="${ row.period}"></c:out> </td>
<td><c:out value="${ row.room}"></c:out> </td>
<td><a href="Controller?page=add-course&code=${ row.course_code}&id=${ id}" style="background:royalblue; color:white; padding:5px"><c:out value="add"></c:out></a></td>
</tr>

</c:forEach>
</table>
</div>
</div>


</div>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>