<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
<div class="card col-6 offset-3"">
<form:form method="POST" action="/student/create" modelAttribute="newStudent">
		<div class = "form-group">
		<form:label path="name">Student's Name:</form:label>
    	<form:input path="name" class="form-control"/>
    	<form:errors class ="text-danger" path="name"/>
		</div>
		    	<form:input type="hidden" path="user" value="${loggedInUser}"/>
		<button class ="btn-primary">Add This Student</button>
			</form:form>
			</div>
</div>
</body>
</html>