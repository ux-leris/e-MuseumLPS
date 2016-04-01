<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
        <spring:url value="/resources/imgs/proc.jpg" var="image" />
        <spring:url value="/resources/imgs/MuseuPaulista.JPG" var="museu" />
        <spring:url value="/resources/imgs/logo.jpg" var="logo" />
        <spring:url value="/resources/imgs/Gabriela.jpg" var="gabriela" />
        <spring:url value="/resources/imgs/Mauricio.jpg" var="mauricio" />
        <spring:url value="/resources/imgs/Monique.jpg" var="monique" />
	
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
    <body ng-app="app">
        <div class="row" style="margin:0px;" >
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
                            <li ><a href="${contextPath}/MuseuBaseline/object/hello">Home</a></li>
                            <li  ><a href="${contextPath}/MuseuBaseline/object/galeria">Museu</a></li>
                            <li><a href="${contextPath}/MuseuBaseline/object/desafios">Desafios</a></li>
                            <li class="active"><a href="${contextPath}/MuseuBaseline/object/perguntas" >Pergunte ao professor</a></li>
                            <li ><a href="${contextPath}/MuseuBaseline/object/sobre">Sobre o museu</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="container-fluid perguntas"  ng-controller="QuestionsCtrl">
            
            <div class="row" >
                <div class="col-sm-6 museu">
                    <div class="row" id="museu"  style="float:right;">
                        <h2 >Mande sua pergunta para o professor</h2>
                    </div>
                    <div class="forms" style="padding:20px;float:right;padding-right:0px;">
                        <div class="col-sm-2" style="text-align:right;padding:0px;margin-top:8px;">
                        Nome: 
                        </div>
                        <div class="col-sm-10" style="padding-right:0px;">
                        <input type="text" name="Nome" ng-model="nome" class="form-control"placeholder="Digite seu nome">
                        </div>
                         <div class="col-sm-2" style="text-align:right;padding:0px;margin-top:23px;">
                        Pergunta: 
                        </div>
                        <div class="col-sm-10" style="margin-top:15px;padding-right:0px;">
                        <input type="text" name="Pergunta" ng-model="pergunta" class="form-control"placeholder="Digite sua pergunta" style="height:100px;">
                        </div>
                        <button  class="btn btn-default" ng-click="enviarPergunta()" value="Enviar" style="float:right; margin:15px;margin-right:0px;vertical-align: top" >
                            Enviar 
                        </button>
                    </div>
                </div>
                <div class="col-sm-5" style="border:1px gray;margin-left:50px;margin-top:30px;">
                    
                    <div class="row" id="museu" style="margin-bottom:0px;">
                        <h4>Perguntas anteriores</h4>
                    </div>
                    <div class="row perguntasAnteriores">
                        <div class = "col-sm-5"></div>
                        <div class = "col-sm-7">
                            <input type="text" name="search" class="form-control" ng-model="buscaPalavra" style="display:block;float:left;  width:95%; margin-right:50px;" placeholder="Digite a pergunta que deseja procurar">
                        </div>
                    </div>
                    <div class="pre-scrollable" style="height:500px;margin-top:10px;">
                        
                        <div ng-repeat="pergunta in perguntas | filter:buscaPalavra" style="margin:10px; border-bottom:1px solid gray;"> 
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
            </div>
            
        </div>

    </body>
</html>
