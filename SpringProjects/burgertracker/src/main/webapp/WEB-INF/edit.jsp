<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Edit Burger</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container text-center">
        <h1 class="my3">Edit Burger</h1>
        <form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
            <input type="hidden" name="_method" value="put">
            <div class="container my-2">
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </div>
            <div class="container my-2">
                <form:label path="restaurant">Restaurant</form:label>
                <form:errors path="restaurant"/>
                <form:input path="restaurant"/>
            </div>
            <div class="container my-2">
                <form:label path="rating">Rating</form:label>
                <form:errors path="rating"/>
                <form:input path="rating"/>
            </div>
            <div class="container my-2">
                <form:label path="notes">Notes</form:label>
                <form:errors path="notes"/>
                <form:input path="notes"/>
            </div>
            <input type="submit" class="btn btn-primary my-2" value="Submit">
        </form:form>
        <div class="container text-center">
            <a href="/" class="btn btn-primary my-5">Back To All Burgers</a>
        </div>
    </div>

</body>
</html>