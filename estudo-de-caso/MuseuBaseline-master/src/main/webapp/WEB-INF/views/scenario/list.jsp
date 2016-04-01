<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Listing Scenarios</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Historical Time</td>
			<td>Objects</td>
			<td>Delete?</td>
		</tr>
		<c:forEach items="${list}" var="scenario">
			<tr>
				<td><a href="scenario/edit?id=${scenario.getId()}">${scenario.getId()}</a></td>
				<td>${scenario.getName()}</td>
				<td>${scenario.getHistoricalTime().getTime()}</td>
				<td><c:forEach items="${scenario.getObjects()}" var="obj">
						${obj.getId()} - ${obj.getName()}
						<br />
					</c:forEach></td>
				<td><a href="scenario/del?id=${scenario.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>