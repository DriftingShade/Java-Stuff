<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Edit ${book.title}</title>
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
	<h2 class="text-center my-5">Edit ${book.title}</h2>
	<div class="main mx-auto my-5 w-50 text-center">
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put">
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
</body>
</html>