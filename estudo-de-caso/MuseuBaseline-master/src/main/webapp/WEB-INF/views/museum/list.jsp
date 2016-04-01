<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Listing Museums</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Scenarios</td>
			<td>Delete?</td>
		</tr>
		<c:forEach items="${list}" var="museum">
			<tr>
				<td><a href="museum/edit?id=${museum.getId()}">${museum.getId()}</a></td>
				<td>${museum.getName()}</td>
				<td><c:forEach items="${museum.getScenarios()}" var="sce">
						${sce.getId()} - ${sce.getName()}
						<br />
					</c:forEach></td>
				<td><a href="museum/delete?id=${museum.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>