<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>Welcome to Easy ABA</h1>
<a href="/student/new">Add a new student</a>

<a href="activity1/new">Make new Tacting Activity</a>
<a href="/logout" id="right">Logout</a>
<table class="table table-striped">
<thead>
<tr>
<th>Student Name</th>
<th>Tacting Score</th>
<!-- <th>Listener Response Score</th> -->


</tr>
</thead>
<c:forEach items="${user.students}" var="student">
	<tr>
		<td>${student.name }</td>

		<td>${student.getAverageScore()}</td>
	</tr>	
</c:forEach>
</table>
<table class="table table-striped">
<thead>
<tr>
<th>Student's Activity</th>
<th>Actions</th>
<!-- <th>Listener Response Score</th> -->


</tr>
</thead>
<c:forEach items="${activities}" var="activity">
	<tr>
		<td>${activity.student.name }</td>
		<td><a href="/activity1/${activity.id}">Let's Play</a></td>
		<td><a href="/activity1/edit/${activity.id}">Update</a></td>
		<td><form:form action="/activity1/delete/${activity.id}" method="delete">
		<button>Delete</button></form:form></td>
	</tr>	
</c:forEach>
</table>


</div>
</body>
</html>