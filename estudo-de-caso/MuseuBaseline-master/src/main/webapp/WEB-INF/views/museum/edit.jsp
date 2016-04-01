<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Edit Museum</title>
</head>
<body>
	<h3>Edit Museum</h3>
	<form action="editMuseum" method="post">
		Name: <input type="text" name="name" value="${museum.getName() }" /><br>
		<br><input type="submit" value="Edit">
	</form>
</body>
</html>