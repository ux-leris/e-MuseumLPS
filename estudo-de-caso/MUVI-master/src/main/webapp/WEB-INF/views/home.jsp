<%-- 
    Document   : home
    Created on : 08/10/2015, 09:02:45
    Author     : Guilherme JC Gois
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MUVI - Home</title>

		<c:url value="/resources/css/main.css" var="maincss"/>
		<link href="${maincss}" rel="stylesheet">

		<c:url value="/resources/css/landscape/home.css" var="landhomecss"/>
		<link href="${landhomecss}" rel="stylesheet" media="screen and (orientation: landscape)">
		<c:url value="/resources/css/portrait/home.css" var="porthomecss"/>
		<link href="${porthomecss}" rel="stylesheet" media="screen and (orientation: portrait)">
		<c:url value="/resources/css/home.css" var="homecss"/>
		<link href="${homecss}" rel="stylesheet">
	</head>
	<body>
		<section>
			<article>
				<h1>${museum.name}</h1>
				<div>
					<a class="button button-home" href="/navegar?mode=aleatory"><p>Aleatória</p></a><!--
					--><a class="button button-home" href="/navegar?mode=guided"><p>Guiada</p></a>
				</div>
			</article>
		</section>
	</body>
</html>
