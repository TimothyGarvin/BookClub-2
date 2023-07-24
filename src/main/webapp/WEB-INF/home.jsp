<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Welcome, <c:out value="${userName}"/>!</h1>
<h3>Books from everyone's shelves:</h3>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Posted By</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="book" items="${bookList}">
			<tr>
				<td><c:out value="${book.id}"/></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
				<td><c:out value=""/>${book.author}</td>
				<td><c:out value=""/>${book.owner.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/logout">Logout</a>
<a href="/books/new">Add to my shelf</a>
</body>
</html>