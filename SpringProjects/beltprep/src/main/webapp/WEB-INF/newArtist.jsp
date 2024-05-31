<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Add An Artist</title>
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
    <div class="main mx-auto w-75">
        <h1 class="my-5 text-center">Add An Artist</h1>
        <div class="form-control">
            <form:form action="/artists/new" method="post" modelAttribute="artist">
                <form:label path="name">Artist Name:</form:label>
                <form:errors path="name" class="form-control"/>
                <form:input path="name" class="form-control"/>

                <form:label path="numOfAlbums">Number Of Albums</form:label>
                <form:errors path="numOfAlbums" class="form-control"/>
                <form:input path="numOfAlbums" type="number" class="form-control"/>

                <form:label path="genre">Genre:</form:label>
                <form:errors path="genre" class="form-control"/>
                <form:select path="genre" class="form-select">
                    <form:option value="Pop">Pop</form:option>
                    <form:option value="Metal">Metal</form:option>
                    <form:option value="Country">Country</form:option>
                    <form:option value="Hip-Hop/Rap">Hip-Hop/Rap</form:option>
                    <form:option value="Jazz">Jazz</form:option>
                    <form:option value="R&B">R&B</form:option>
                    <form:option value="Rock">Rock</form:option>
                </form:select>

                <form:label path="stillTouring">Still Touring?</form:label>
                <form:errors path="stillTouring" class="form-control"></form:errors>
                <form:checkbox path="stillTouring" class="form-check"/>

                <button type="submit" class="btn btn-primary my-3">Submit</button>
            </form:form>
        </div>
</body>
</html>