<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books (rendrd)</title>
</head>
<body>
	<div>
		<h3>Drink List:</h3>
		<h1>Hello, and welcome to the rendering of all yer Books!</h1>
		<div>
			<h3>Books</h3>
			<c:forEach var="book" items="${allBooks}">
				<div style="border: solid 2px; padding: 1rem; margin-bottom: 0.5rem; max-width: 30vw;">
					<p>Title | <c:out value="${book.title}"/></p>
					<p>Description | <c:out value="${book.description}"/></p>
					<p>Language | <c:out value="${book.language}"/></p>
					<p>Pages | <c:out value="${book.numberOfPages}"/></p>
					<a href="/book/${book.id}/update"><button>Edit</button></a>
					<form action="/book/${book.id}/" method="POST">
						<input type="hidden" name="_method" value="DELETE"/>
						<button>Delete</button>
					</form>
				</div>
			</c:forEach>
		</div>
		<a href="/book/create"><button>Create a New Book</button></a>
	</div>
</body>
</html>