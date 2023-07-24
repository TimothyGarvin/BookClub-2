<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<h2><c:out value="${book.owner.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
	<h3>Here are <c:out value="${book.owner.name}"/>'s thoughts.</h3>
	<div>
		<hr/>
			<p><c:out value="${book.thoughts}"/></p>
		<hr/>
	</div>
	<form:form action="/books/${book.id}" method="post">
	<input type="hidden" name="_method" value="delete">
	<input type="submit" value="Delete">
	</form:form>
	<a href="/books/edit/${book.id}">Edit</a>
	<div></div><hr/>
	<a href="/books">Return Home</a>
</body>
</html>