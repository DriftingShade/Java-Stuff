<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Artists Dashboard</title>
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
			<h1 class="text-center">Welcome, ${user.firstName}</h1>
			<div class="d-flex">
				<a href="/artists/new" class="btn btn-primary text-center mx-3">Add An Artist!</a>
				<a href="/logout" class="btn btn-danger text-center mx-3">Log Out</a>
			</div>
		</div>
	</div>
	<div class="main mx-auto w-75">
		<h2 class="my-5 text-center">All Artists</h2>
		<table class="table mx-auto align-center text-center">
			<thead>
				<tr>
					<th>Artist Name</th>
					<th># Of Albums</th>
					<th>Genre</th>
					<th>Still Touring?</th>
				</tr>
			</thead>
			<c:forEach items="${artists}" var="artist">
				<tr>
					<td><a href="/artists/${artist.id}">${artist.name}</a></td>
					<td>${artist.numOfAlbums}</td>
					<td>${artist.genre}</td>
					<td>${artist.stillTouring}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>