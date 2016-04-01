<%-- 
    Document   : challenge
    Created on : Oct 13, 2015, 9:41:09 AM
    Author     : Guilherme J de C Gois
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MUVI - Desafio!</title>

    <c:url value="/resources/css/main.css" var="maincss"/>
    <c:url value="/resources/css/menu.css" var="menucss"/>
    <c:url value="/resources/css/challenge.css" var="challengecss"/>

    <c:url value="/resources/js/DOMUtils.js" var="domutilsjs" />
    <c:url value="/resources/js/MUVI.js" var="muvijs" />
    <c:url value="/resources/js/challenge.js" var="challengejs" />

    <link href="${maincss}" rel="stylesheet">
    <link href="${menucss}" rel="stylesheet">
    <link href="${challengecss}" rel="stylesheet">
</head>
<body>
    <%@ include file="../jspf/menu.jspf" %>

    <section id="challenge-section">
        <article>
            <section>
                <header>
                    <h1 id="title"></h1>
                </header>
                <article id="challenge-alternatives">
                    <div id="alternative1"><span></span></div>
                    <div id="alternative2"><span></span></div>
                    <div id="alternative3"><span></span></div>
                </article>
                <footer>
                    <nav>
                        <div id="finish"><span>Finalizar</span></div>
                        <div id="cancel"><span>Cancelar</span></div>
                        <div id="next"><span>#</span></div>
                        <div id="state"><span></span></div>
                        <div id="back"><span>#</span></div>
                    </nav>
                </footer>
            </section>
        </article>
    </section>

    <script src="${domutilsjs}" type="text/javascript"></script>
    <script src="${muvijs}" type="text/javascript"></script>
    <script src="${challengejs}" type="text/javascript"></script>
</body>
</html>
