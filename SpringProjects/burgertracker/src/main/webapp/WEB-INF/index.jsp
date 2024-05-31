<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker!</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center my-5">All Burgers</h1>
	<table class="table text-center my-5">
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (Out of 5)</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${burgers}" var="burger">
				<tr>
					<td>${burger.name}</td>
					<td>${burger.restaurant}</td>
					<td>${burger.rating }</td>
					<td><a href="/burgers/${burger.id}/edit" class="btn btn-warning">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="container text-center my-5">
		<h2>Create A Burger!</h2>
		<form:form action="/createburger" method="post" modelAttribute="burger">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="restaurant">Restaurant</form:label>
				<form:errors path="restaurant"/>
				<form:input path="restaurant"/>
			</p>
			<p>
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating"/>
				<form:input path="rating"/>
			</p>
			<p>
				<form:label path="notes">Notes</form:label>
				<form:errors path="notes"/>
				<form:textarea path="notes"/>
			</p>
  			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>