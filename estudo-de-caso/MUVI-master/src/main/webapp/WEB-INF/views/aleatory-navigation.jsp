<%-- 
	Document   : aleatory-navigation
	Created on : 20/11/2015, 23:50:37
	Author     : Guilherme JC Gois
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MUVI - Visita Aleatória</title>

		<c:url value="/resources/css/challenge.css" var="challengecss"/>
		<c:url value="/resources/css/main.css" var="maincss"/>
		<c:url value="/resources/css/menu.css" var="menucss"/>
		<c:url value="/resources/css/navigation.css" var="navigationcss"/>

		<c:url value="/resources/js/challenge.js" var="challengejs" />
		<c:url value="/resources/js/DOMUtils.js" var="domutilsjs" />
		<c:url value="/resources/js/menu.js" var="menujs" />
		<c:url value="/resources/js/MUVI.js" var="muvijs" />
		<c:url value="/resources/js/navigation.js" var="navigationjs" />

		<link href="${challengecss}" rel="stylesheet">
		<link href="${maincss}" rel="stylesheet">
		<link href="${menucss}" rel="stylesheet">
		<link href="${navigationcss}" rel="stylesheet">

	</head>
	<body>
		<%@ include file="../jspf/menu-aleatory.jspf" %>

		<section id="object-section">
			<nav>
				<ul>
					<li><div id="backto" class="button <c:if test="${!hasPrevious}">hide</c:if>"><a id="abackto" href="/navegar/a/anterior" class="nav-sce-btn">#</a></div></li>
					<li><div id="state" class="nav-sce-location">${atual} de ${numItems}</div></li>
					<li><div id="goto" class="button <c:if test="${!hasNext}">hide</c:if>"><a id="agoto" href="/navegar/a/proximo" class="nav-sce-btn">#</a></div></li>
					</ul>
				</nav>
			<%@ include file="../jspf/navigation-board.jspf" %>
		</section>

		<c:if test="${navigationNode.scenario.class.name == 'com.lpsmuseum.dto.scenario.ScenarioChallenge'}">
			<%@ include file="../jspf/challenge.jspf" %>
		</c:if>

		<script src="${domutilsjs}" type="text/javascript"></script>
		<script src="${muvijs}" type="text/javascript"></script>
		<script src="${menujs}" type="text/javascript"></script>
		<script src="${navigationjs}" type="text/javascript"></script>
		<script src="${challengejs}" type="text/javascript"></script>

		<script>
			MUVI.keyboard(
					function () {
						console.log('left');
						document.getElementById('abackto').click();
					},
					function () {
						console.log('right');
						document.getElementById('agoto').click()
					}
			);
		</script>

	</body>
</html>
