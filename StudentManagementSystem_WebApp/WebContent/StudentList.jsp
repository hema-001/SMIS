<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">

body
{
	margin:0px;
	background:lightgray;
	background-image: url("img/Capture1.PNG");
	background-size: 100% 100%;
	background-attachment: fixed;	
}

header
{
	height:60px;
	background:darkgoldenrod;
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
	background:darkgoldenrod;
	border-radius:3px;
	float:right;
	margin:18px;
	color:white;
	font-size:17px;
}

.container
{
	margin:0px auto;
	width:50%;
	background:white;
	padding:10px;
}

table
{
	margin: 0px auto;
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
	background:darkgoldenrod;
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
<h4><i class='fas fa-chalkboard-teacher'></i>Students List</h4>
<button onClick="window.location='teacherlogin.jsp';">log out</button>
<button onclick="window.location='TeacherHome.jsp';">Home</button>
</header>

<div class="container">

<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result" dataSource="${ db}">
 select s.name, s.id from student as s, select_course as sc where s.id in  (select sc.id from select_course  where sc.course_code=<%= request.getAttribute("code") %>);
</sql:query>

<table>
<tr>
<th>Student ID</th>
<th>name</th>
</tr>
</table>


<div class="row" style="margin-top:20px">
<div class="col-md-12" style="margin:0px auto; text-align:center">

<c:forEach items="${ result.rows}" var="row">

<table>
<tr>
<td><c:out value="${ row.id}"></c:out> </td>
<td><c:out value="${ row.name}"></c:out> </td>
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