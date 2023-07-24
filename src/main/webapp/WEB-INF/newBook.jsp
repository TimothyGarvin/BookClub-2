<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Book</title>
</head>
<body>
	<h1>Add a book</h1>
	<form:form action="/books/create" method="post" modelAttribute="newBook">
		<div>
			<form:label path="title">Title:</form:label>
			<div></div>
			<form:errors path="title"/>
			<div></div>
			<form:input path="title"/>
		</div><hr/>
		<div>
			<form:label path="author">Author:</form:label>
			<div></div>
			<form:errors path="author"/>
			<div></div>
			<form:input path="author"/>
		</div><hr/>
		<div>
			<form:label path="thoughts">My Thoughts:</form:label>
			<div></div>
			<form:errors path="thoughts"/>
			<div></div>
			<form:textarea path="thoughts"/>
		</div><hr/>
		<div>
			<form:input type="hidden" path="owner" value="${userId}"/>
		</div>
		<div>
			<input type="submit" value="Submit">
		</div>
	</form:form>
	<a href="/books">Return Home</a>
</body>
</html>