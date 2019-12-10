<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifications</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">

body
{
	margin:0px;
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

.container
{
	margin:0px auto;
	width:90%;
	background:white;
	padding:10px;
}

th
{
	color:dodgerblue;
}

td
{
	width:1200px;
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
  	margin-top: 50px;
}

</style>

</head>
<body>

<header>
<h4><i class='fas fa-chalkboard-teacher'></i>Notifications</h4>
<button onClick="window.location='login.jsp';">drop out</button>
<button onclick="window.location='home.jsp';">home</button>
</header>

<div class="container">

<sql:setDataSource url="jdbc:mysql://localhost:3306/student_management_system?autoReconnect=true&&useSSL=false" user="root" password="124536" driver="com.mysql.jdbc.Driver" var="db"/>

<sql:query var="result" dataSource="${ db}">
select  title, content,  issue_date, author from notifications order by issue_date desc;
</sql:query>



<div class="row" style="margin-top:20px">
<div class="col-md-12" style="margin:0px auto">

<c:forEach items="${ result.rows}" var="row">

<table>
<tr>
<th>Time</th>
</tr>

<tr>
<td style="text-align:top"><c:out value="${ row.issue_date}"></c:out> </td>
</tr>

<tr>
<th>Title</th>
</tr>

<tr>
<td><c:out value="${ row.title}"></c:out> </td>
</tr>

<tr>
<th>Content</th>
</tr>

<tr>
<td  style="width:500px"><c:out value="${ row.content}"></c:out> </td>
</tr>

<tr>
<th>Author</th>
</tr>

<tr>
<td><c:out value="${ row.author}"></c:out></td>
</tr>

<tr>
<td><hr style="border:1px solid gray"></td>
</tr>

</table>

</c:forEach>

</div>
</div>


</div>

<footer>
Copyright &copy; TechnoRhino 2019
</footer>


<%--

<table>
<th style="width:500px">Content</th>
</tr>
</table>

 --%>

</body>
</html>