<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>${artist.name}</title>
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
				<a href="/dashboard" class="btn btn-primary text-center mx-3">Dashboard</a>
				<a href="/logout" class="btn btn-danger text-center mx-3">Log Out</a>
			</div>
		</div>
	</div>
    <div class="main mx-auto w-75 my-3">
        <h2 class="text-center my-3">Artist Information</h2>
        <h4 class="text-center my-3">Artist Name: ${artist.name}</h4>
        <h4 class="text-center my-3">Number Of Albums: ${artist.numOfAlbums}</h4>
        <h4 class="text-center my-3">Genre: ${artist.genre}</h4>
        <h4 class="text-center my-3">Still Touring?  ${artist.stillTouring}</h4>
        <br>
    </div>
        <div class="d-flex text-center w-25 mx-auto justify-content-center">
            <c:if test="${user.id == artist.user.id}">
                <a href="/artists/${artist.id}/edit" class="btn btn-warning mx-3">Edit</a>
                <form action="/artists/${artist.id}/delete" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </c:if>
        </div>

</body>
</html>