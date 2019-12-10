<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">

body
{
	margin:0px;
	background:lightgray;
	background-image: url("img/Capture3.PNG");
	background-size: 100% 100%;
	background-attachment: fixed;	
}

header
{
	height:60px;
	background:goldenrod;
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
	background:goldenrod;
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
<h4><i class='fas fa-chalkboard-teacher'></i>Self-Selected Courses</h4>
<button onClick="window.location='login.jsp';">log out</button>
<button onclick="window.location='home.jsp';">Home</button>
</header>

<div class="container">

<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result" dataSource="${ db}">
select distinct c.course_code, c.name,  c.teacher, c.credits, c.day, c.period, c.room from courses as c, select_course as cs, student as s where cs.course_code=c.course_code and cs.id=<%= session.getAttribute("id") %>;
</sql:query>

<table>
<tr>
<th>course code</th>
<th>name</th>
<th>Teacher</th>
<th>Credits</th>
<th>Week</th>
<th>Period</th>
<th>Room</th>
<th>Option</th>
</tr>
</table>


<div class="row" style="margin-top:20px">
<div class="col-md-12" style="margin:0px auto; text-align:center">

<c:forEach items="${ result.rows}" var="row">

<table>
<tr>
<td><c:out value="${ row.course_code}"></c:out> </td>
<td><c:out value="${ row.name}"></c:out> </td>
<td><c:out value="${ row.teacher}"></c:out></td>
<td><c:out value="${ row.credits}"></c:out> </td>
<td><c:out value="${ row.day}"></c:out> </td>
<td><c:out value="${ row.period}"></c:out> </td>
<td><c:out value="${ row.room}"></c:out> </td>
<td><a href="Controller?page=remove-course&code=${ row.course_code}&id=${id}" style="background:royalblue; color:white; padding:5px"><c:out value="Remove"></c:out></a></td>
</tr>
</table>

</c:forEach>

</div>
</div>


</div>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>

</body>
</html>