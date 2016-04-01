<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Listing Objects</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Image</th> 
			<th>Delete?</th>
		</tr>
		<c:forEach items="${list}" var="object"><tr>
				<td><a href="object/edit?id=${object.getId()}">${object.getId()}</a></td>
				<td>${object.getName()}</td>
				<c:choose>
					<c:when test="${object.class.name == 'com.lpsmuseum.dto.object.Image'}">
						<td>Image</td>
						<td><img src="${object.getUrlAddress()}" /></td>
					</c:when>
					<c:when test="${object.class.name == 'com.lpsmuseum.dto.object.Text'}">
						<td>Text</td>
						<td>-</td>
					</c:when>
					<c:otherwise>
						<td>Object</td>
						<td>-</td>
					</c:otherwise>
				</c:choose>
				<td><a href="object/delete?id=${object.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="object/create">Add new object</a>
</body>