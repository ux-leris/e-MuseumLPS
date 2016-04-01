<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="app">
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">

        <!--
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/lib/angular.js"></script>
        <script type="text/javascript" src="js/lib/angular-route.js"></script>
        <script type="text/javascript" src="js/lib/angular-resource.js"></script>
        <script type="text/javascript" src="js/app.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular-animate.js"></script>
        <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.13.4.js"></script>

        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
        <link href="bootstrap-theme.css" rel="stylesheet" />
        <link href="bootstrap-theme.min.css" rel="stylesheet" />
        <link href="bootstrap.css" rel="stylesheet" />
        <link href="bootstrap.min.css" rel="stylesheet" />
        <link href="style.css" rel="stylesheet">
        -->
        <spring:url value="/resources/style.css" var="styleCss" />
        <spring:url value="/resources/styleMobile.css" var="styleMobileCss" />
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
        <spring:url value="/resources/imgs/musobj4.jpg" var="image" />
	
        <link href="${bootstrapMinCss}" rel="stylesheet" />
        <link href="${bootstrapThemeCss}" rel="stylesheet" />
        <link href="${bootstrapThemeMinCss}" rel="stylesheet" />
        <link href="${bootstrap}" rel="stylesheet" />
        <link href="${bootstrapMin}" rel="stylesheet" />
	<link href="${styleCss}" rel="stylesheet" />
	<link href="${styleMobileCss}" rel="stylesheet" />
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

    </head>
    <body ng-controller="MainController">
        <!--menu-->
        <c:set var="contextPath" value="${pageContext.request.contextPath }" />
        
        <div class="row menuHidden" style="margin:0px;display:none;">
                <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-horiz">
                            <li class="active"><a href="${contextPath}/object/hello">Home</a></li>
                            <li  ><a href="${contextPath}/object/galeria">Museu</a></li>
                            <li  ><a ng-click="openDesafios()">Desafios</a></li>
                            <li><a href="${contextPath}/object/perguntas">Pergunte ao professor</a></li>
                            <li><a href="${contextPath}/object/sobre">Sobre o Museu</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
    
            </div>
        
        <div  class="container-fluid mainPage" >
             <div class="col-sm-3" >
                <div id="menu-title">
                    <div class="row">
                        <div class="well">
                             <h5>Menu</h5>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <ul id="sidebar" class="nav nav-pills nav-stacked">
                        
                        <li><a href="${contextPath}/object/galeria">Galeria</a></li>
                        <li><a href="${contextPath}/object/desafios" >Desafios</a></li>
                        <li><a href="${contextPath}/object/perguntas">Pergunte ao professor</a></li>
                        <li><a href="${contextPath}/object/sobre">Sobre o museu</a></li>
                        <li><a href="${contextPath}/object/sobre#nos">Sobre nós</a></li>
                    </ul>
                </div>
            </div>
             <div id ="main" class ="col-sm-9" >
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${image}" alt="Museu da Política Brasileira">

                        </div>
                        <div class="item">
                            <img src="${image}" alt="...">

                        </div>
                    </div>
                </div>
                <div class="row">
                    <!--museum title-->
                    <div id="title-carousel">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="page-header">
                                    <h1 class="text-center" id="main-title">Museu da República</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--buttons-->
                    <div id="buttons-carousel">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="row">
                                        <div class="col-sm-4"></div>
                                        <div class="col-sm-4">
                                            <button type="button" class="btn btn-primary" >
                                                <a style="color:white" href="${contextPath}/object/tour" >Inicie o tour</a>
                                            </button>
                                        </div>
                                        <div class="col-sm-2"></div>
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="row">
                                        <div class="col-sm-2"></div>
                                        <div class="col-sm-4">
                                            <button type="button"  class="btn btn-primary">
                                                  <a style="color:white" href="${contextPath}/object/desafios" >Teste seus conhecimentos</a>
                                            </button>
                                        </div>
                                        <div class="col-sm-4"></div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
