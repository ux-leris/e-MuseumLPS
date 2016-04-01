<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MUVI - Desafio?!</title>
        
        <c:url value="/resources/css/main.css" var="maincss"/>
        <link href="${maincss}" rel="stylesheet">
        
        <c:url value="/resources/css/notice.css" var="noticecss"/>
        <link href="${noticecss}" rel="stylesheet">
    </head>
    <body>
        <section>
            <article>
                <section>
                    <header>
                        <h1>${title}</h1>
                    </header>
                    <article>
                        <p>${text}</p>
                    </article>
                    <footer>
                        <c:forEach var="action" items="${actions}">
                            <a href="${action.value}">${action.key}</a>
                        </c:forEach>
                    </footer>
                </section>
            </article>
        </section>
    </body>
</html>
