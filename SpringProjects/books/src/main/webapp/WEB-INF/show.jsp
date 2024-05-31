<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Book Information</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	
	<div class="card">
		<div class="card-body">
			<div class="card-title">
				<h3>Title: <c:out value="${book.title}"/></h3>
			</div>
			<div class="card-text">
				<p>Description: <c:out value="${book.description}"></c:out></p>
				<p>Language: <c:out value="${book.language }"></c:out></p>
				<p>Number of Pages: <c:out value="${book.numberOfPages }"></c:out></p>
				<p>It works!</p>
			</div>
		</div>
	</div>
</body>
</html>