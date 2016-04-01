<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New object added</title>
</head>
<body>
<h3>New Object Created: ${ object.getName() }</h3>
<p>Date: ${ format.format(object.getDate().getTime()) }</p>
<c:choose>
<c:when test="${object.class.name == 'com.lpsmuseum.dto.object.Image'}">
<p>Image:<img src="${ object.getUrlAddress() }" width="200" height="100" /></p>
</c:when>
<c:when test="${object.class.name == 'com.lpsmuseum.dto.object.Text'}">
<p>Text: ${ object.getName() }</p>
</c:when>
</c:choose>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<a href="${contextPath}/object">Go to list.</a>
</body>
</html>