<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Activity</title>
</head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<body>
<h3>Settings</h3>
<form:form method="put" action="/activity1/update/${updateActivity.id}" modelAttribute="updateActivity">
		<div class = "form-group">
		<form:label path="student">Student Name:</form:label>
    	<form:select path="student" class="form-control">
    	<c:forEach items="${students }" var="student">
    	<form:option value="${student.id}">${student.name }</form:option>
    	</c:forEach>
    	<form:errors class ="text-danger" path="student"/>
    	</form:select>
		</div>
		<div class = "form-group">
		<form:label path="image1">Image URL:</form:label>
    	<form:input path="image1" class="form-control"/>
    	<form:errors class ="text-danger" path="image1"/>
		</div>
		<div class = "form-group">
		<form:label path="image2">Image URL:</form:label>
    	<form:input path="image2" class="form-control"/>
    	<form:errors class ="text-danger" path="image2"/>
		</div>
		<div class = "form-group">
		<form:label path="image3">Image URL:</form:label>
    	<form:input path="image3" class="form-control"/>
    	<form:errors class ="text-danger" path="image3"/>
		</div>
		<div class = "form-group">
		<form:label path="image4">Image URL:</form:label>
    	<form:input path="image4" class="form-control"/>
    	<form:errors class ="text-danger" path="image4"/>
		</div>
		<div class = "form-group">
		<form:label path="image5">Image URL:</form:label>
    	<form:input path="image5" class="form-control"/>
    	<form:errors class ="text-danger" path="image5"/>
		</div>
		<br/>
		<br/>
		<button class ="btn-primary">Update These Images</button>
	</form:form>
</body>
</html>