<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html data-bs-theme="dark">
<head>
<meta charset="ISO-8859-1">
<title>Login And Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container mx-auto text-center my-3">
		<h1>Book Club</h1>
		<h4 class="my-3">A place for friends to share thoughts on books!</h4>
		<div class="container d-flex justify-content-between my-3 text-center">
			<div class="card" style="width: 18rem">
				<div class="card-body">
					<h4 class="card-title">Not A Member? Register Here!</h4>
					<form:form action="/register" method="post"
						modelAttribute="newUser">
						<ul class="list-group list-group-flush form-control">
							<li class="list-group-item text-center"><form:label
									path="name" class="form-label">Name:</form:label> <form:input
									path="name" class="form-control my-3" /> <form:errors
									path="name" /></li>
							<li class="list-group-item text-center"><form:label
									path="email" class="form-label">Email:</form:label> <form:input
									path="email" class="form-control my-3" /> <form:errors
									path="email" /></li>
							<li class="list-group-item" class="form-label"><form:label
									path="password" class="form-label">Password:</form:label> <form:input
									path="password" type="password" class="form-control my-3" /> <form:errors
									path="password" /></li>
							<li class="list-group-item" class="form-label"><form:label
									path="confirm" class="form-label">Confirm:</form:label> <form:input
									path="confirm" type="password" class="form-control my-3" /> <form:errors
									path="confirm" /></li>
						</ul>
						<input type="submit" class="btn btn-primary mt-3"
							value="Register!" />
					</form:form>
				</div>
			</div>
			<div class="card" style="width: 18rem">
				<div class="card-body">
					<h4 class="card-title">Already A Member? Login Here!</h4>
					<form:form action="/login" method="post" modelAttribute="newLogin">
						<ul class="list-group list-group-flush form-control">
							<li class="list-group-item text-center"><form:label
									path="email" class="form-label">Email:</form:label> <form:input
									path="email" class="form-control my-3" /> <form:errors
									path="email" /></li>
							<li class="list-group-item text-center"><form:label
									path="password" class="form-label">Password:</form:label> <form:input
									type="password" path="password" class="form-control my-3" /> <form:errors
									path="password" /></li>
						</ul>
						<input type="submit" class="btn btn-primary mt-3" value="Login!" />
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>