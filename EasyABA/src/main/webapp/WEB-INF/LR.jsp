<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listening Response</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- For any Bootstrap that uses JS or jQuery-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<div class ="container">
<div class="row align-items-center">

<div id="myCarousel" class="carousel slide" data-bs-touch="false">
  <div class="carousel-inner" class="carousel">
  	<ol class= "carousel-indicators">
  		<li data-bs-target="#myCarousel" data-bs-slide-to="0" class="active"></li>
  		<li data-bs-target="#myCarousel" data-bs-slide-to="1" ></li>
  		<li data-bs-target="#myCarousel" data-bs-slide-to="2" ></li>
  		<li data-bs-target="#myCarousel" data-bs-slide-to="3" ></li>
  		<li data-bs-target="#myCarousel" data-bs-slide-to="4" ></li>
  	</ol>
    <div class="carousel-item active" >
      <img class="d-block w-100" src="${activity.image1 }" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${activity.image2 }" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100"  src="${activity.image3 }" alt="Third slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" style="height:auto" src="${activity.image4 }" alt="Fourth slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="${activity.image5 }" alt="Fifth slide">
    </div>
  </div>
  
  <a href="#myCarousel" class="carousel-control-prev" role="button" data-slide="prev">
  <span class="sr-only">Previous</span>
  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
  </a>
  <a href="#myCarousel" class="carousel-control-next" role="button" data-slide="next">
  <span class="sr-only">Next</span>
  <span class="carousel-control-next-icon" aria-hidden="true"></span>
  </a>
</div>
</div>
</div>
<div class="row align-items-center">
<img class="d-block w-25" style="padding-left:120px" src="/c.png" alt="correct"> 
<img class="d-block w-25" style="padding-left:80px" src="/i.png" alt="incorrect">
<img class="d-block w-25" style="padding-left:120px" src="/p.png" alt="prompted">
</div>
<form:form method="POST" action="/activity1/scores" modelAttribute="scores">
<div class = "form-group">
		<form:label path="correct">Score:</form:label>
		<form:hidden path="students" value="${activity.student.id}"/>
    	<form:select path="correct" class="form-control">
    	<form:option value="1">1</form:option>
    	<form:option value="2">2</form:option>
    	<form:option value="3">3</form:option>
    	<form:option value="4">4</form:option>
    	<form:option value="5">5</form:option>
    	</form:select>
    	<button class ="btn-primary">Enter Score</button>
		</div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</body>
</html>