<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Add A Book</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
</head>
<body>
	<div class="navbar bg-body-primary">
		<div class="container-fluid">
			<h1 class="text-center">Welcome, ${user.name}</h1>
			<div class="d-flex">
				<a href="/home" class="btn btn-primary text-center mx-3">Dashboard</a>
				<a href="/logout" class="btn btn-danger text-center mx-3">Log Out</a>
			</div>
		</div>
	</div>
	<div class="main w-25 mx-auto">
		<h2 class="my-5 text-center">Create A Book!</h2>
		<div class="form-control">
			<form:form action="/createbook" method="POST" modelAttribute="book">
				<form:label path="title" >Book Title</form:label>
				<form:errors path="title" class="form-control" />
				<form:input path="title" class="form-control" />
				<form:label path="author" >Author</form:label>
				<form:errors path="author" class="form-control" />
				<form:input path="author" class="form-control" />
				<form:label path="thoughts" >My Thoughts</form:label>
				<form:errors path="thoughts" class="form-control" />
				<form:input type="textarea" path="thoughts" class="form-control" />
				<button type="submit" class="btn btn-primary my-3">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>