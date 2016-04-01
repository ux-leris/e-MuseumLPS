<%-- 
    Document   : busca
    Created on : 15/11/2015, 10:29:40
    Author     : gabriela
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/js/BuscaPergunta.js" var="buscaJs" />
        <spring:url value="/resources/style.css" var="styleCss" />
        <spring:url value="/resources/bootstrap-theme.css" var="bootstrapThemeCss" />
        <spring:url value="/resources/bootstrap-theme.min.css" var="bootstrapThemeMinCss" />
        <spring:url value="/resources/bootstrap.css" var="bootstrap" />
        <spring:url value="/resources/bootstrap.min.css" var="bootstrapMin" />
        <spring:url value="/resources/js/bootstrap.min.css" var="bootstrapMinCss" />
	<spring:url value="/resources/js/jquery/jquery.min.js" var="jquery" />
        <spring:url value="/resources/js/lib/bootstrap.min.js" var="bootstrapMin" />
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapMinJs" />
        <spring:url value="/resources/js/lib/angular.js" var="angularJs" />
	<spring:url value="/resources/js/lib/angular-route.js" var="angularRouteJs" />
        <spring:url value="/resources/js/lib/angular-resource.js" var="angularResourceJs" />
	<spring:url value="/resources/js/lib/angular-animate.js" var="angularAnimateJs" />
        <spring:url value="/resources/ui-bootstrap-tpls-0.13.4.js" var="bootstrapUi" />
        <spring:url value="/resources/js/ngDraggable.js" var="ngDraggable" />
        <spring:url value="/resources/js/app.js" var="appJs" />
        <spring:url value="/resources/imgs/04_Proclamação_da_República_by_Benedito_Calixto_1893.jpg" var="image" />
	
        <link href="${bootstrapMinCss}" rel="stylesheet" />
        <link href="${bootstrapThemeCss}" rel="stylesheet" />
        <link href="${bootstrapThemeMinCss}" rel="stylesheet" />
        <link href="${bootstrap}" rel="stylesheet" />
        <link href="${bootstrapMin}" rel="stylesheet" />
	<link href="${styleCss}" rel="stylesheet" />
        <script src="${jquery}"></script>
        <script src="${bootstrapMin}"></script>
        <script src="${bootstrapMinJs}"></script>
        <script src="${angularJs}"></script>
        <script src="${angularRouteJs}"></script>
        <script src="${angularResourceJs}"></script>
        <script src="${angularAnimateJs}"></script>
        <script src="${bootstrapUi}"></script>        
        <script src="${ngDraggable}"></script>
        <script src="${appJs}"></script>
        <script src="${buscaJs}"></script>
        <title>JSP Page</title>
    </head>
    <body ng-app="buscaPerguntas" ng-controller="busca">
        <!--insira este campo de busca-->
        <div class="row">
            <div class = "col-sm-8"></div>
            <div class ="col-sm-4"> 
                <input type="text" name="search" class="form-control" ng-model="buscaPalavra" style="display:block; float:left; width:80%" placeholder="Digite a pergunta que deseja procurar">
            </div>
        </div>
        <div class="col-sm-5" style="border:1px gray;margin-left:50px;margin-top:30px;">
            <div class="row" id="museu" style="margin-bottom:0px;">
                <h4>Perguntas anteriores</h4>
            </div>
            <div class="pre-scrollable" style="height:500px;">
                <div ng-repeat="pergunta in perguntas| filter:buscaPalavra" style="margin:10px; border-bottom:1px solid gray;">
                    <div class="col-sm-8">
                        De: {{pergunta.nome}}
                    </div>
                    <div class="col-sm-4" style="text-align:right;">
                        em {{pergunta.data}}
                    </div>
                    <br />
                    <p style="font-size:1.3em;text-align: justify"><b>{{pergunta.pergunta}}</b></p>
                    <p style="text-align: justify;">R. {{pergunta.resposta}}</p>
                </div>
            </div>
        </div>
    </body>
</html>
