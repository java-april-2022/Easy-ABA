<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Easy ABA</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<h1>Easy ABA</h1>

	<div class="d-flex justify-content-center">
		
		<form:form method="POST" action="/registration" modelAttribute="newUser" class="col-4 p-4 bg-dark text-light">
		<h3>Register User</h3>
		<div class = "form-group">
		<form:label path="email">Email:</form:label>
    	<form:input path="email" class="form-control"/>
    	<form:errors class ="text-danger" path="email"/>
		</div>
		<div class = "form-group">
		<form:label path="password">Password:</form:label>
    	<form:password path="password" class="form-control"/>
    	<form:errors class ="text-danger" path="password"/>
		</div>
		<div class = "form-group">
		<form:label path="confirm">Confirm Password:</form:label>
    	<form:password path="confirm" class="form-control"/>
    	<form:errors class ="text-danger" path="confirm"/>
		</div>
		<br/>
		<button class ="btn-primary">Register</button>
		</form:form>


 	
 	<form:form action="/login" modelAttribute="newLogin" class="col-4 p-4 bg-dark text-light">
 	<div class="form-group">
 	<h3>Login</h3>
 		<form:errors class ="text-danger" path="email"/>
 		<form:label path="email">Email:</form:label>
    	<form:input path="email" class="form-control"/>	
 	</div>
 	<div class="form-group">
 		<form:errors class ="text-danger" path="password"/>
 		<form:label path="password">Password:</form:label>
    	<form:password path="password" class="form-control"/>	
 	</div>
 	<br/>
		<button class ="btn-primary">Login</button>
 	</form:form>
	</div>


</body>
</html>