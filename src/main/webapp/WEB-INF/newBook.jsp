<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book | Create</title>
</head>
<body>
	<h1>Create a new Book!</h1>
	<form:form action="/book/create" method="POST" modelAttribute="book">
		<div>
			<form:label path="title">Title</form:label>
			<form:input path="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<form:label path="description">Description</form:label>
			<form:input path="description"/>
			<form:errors path="description"/>
		</div>
		<div>
			<form:label path="language">Language</form:label>
			<form:input path="language"/>
			<form:errors path="language"/>
		</div>
		<div>
			<form:label path="numberOfPages">Number of Pages</form:label>
			<form:input path="numberOfPages"/>
			<form:errors path="numberOfPages"/>
		</div>
		<button>Create Book</button>
	</form:form>
	<a href="/"><button>Home</button></a>
</body>
</html>