<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>${book.title}</title>
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
	<div class="main mx-auto my-5 w-50 text-center">
		<h1 class="my-3">${book.title}</h1>
		<c:if test="${user.id == book.user.id}">
            <h3 class="my-3">You read this book by ${book.author}.</h3>
            <h3 class="my-3">Here are your thoughts:</h3>
        </c:if>
        <c:if test="${user.id != book.user.id}">
            <h3 class="my-3">${book.user.name} read this book by ${book.author}.</h3>
            <h3 class="my-3">Here are their thoughts:</h3>
        </c:if>
        <hr />
        <h3 class="my-5">${book.thoughts}</h3>
        <hr />
        <c:if test="${user.id == book.user.id}">
            <div>
                <a href="/books/${book.id}/edit" class="btn btn-warning">Edit</a>
                <br>
                <div class="container my-3">
                    <form action="/books/${book.id}/delete" method="post">
                        <input type="hidden" name="_method" value="delete" />
                        <input type="submit" class="btn btn-danger" value="Delete" />
                    </form>
                </div>
            </div>
        </c:if>
	</div>
</body>
</html>