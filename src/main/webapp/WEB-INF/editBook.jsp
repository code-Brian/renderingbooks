<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book | Update</title>
</head>
<body>
	<h1>Edit a Book!</h1>
	<form:form action="/book/${book.id}/update" method="POST" modelAttribute="book">
		<input type="hidden" name="_method" value="PUT">
		<div>
			<form:label path="title">Title</form:label>
			<form:input path="title" value="${book.title}"/>
			<form:errors path="title"/>
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:input path="description" value="${book.description}"/>
			<form:errors path="description"/>
		</div>
		<div>
			<form:label path="language">Language</form:label>
			<form:input path="language" value="${book.language}"/>
			<form:errors path="language"/>
		</div>
		<div>
			<form:label path="numberOfPages">Number of Pages</form:label>
			<form:input path="numberOfPages" value="${book.numberOfPages}"/>
			<form:errors path="numberOfPages"/>
		</div>
		<button>Save Changes to Book</button>
	</form:form>
	<a href="/"><button>Home</button></a>
</body>
</html>