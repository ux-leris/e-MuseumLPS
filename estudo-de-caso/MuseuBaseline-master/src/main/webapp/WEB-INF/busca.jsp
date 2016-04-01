<%-- 
    Document   : busca
    Created on : 15/11/2015, 10:29:40
    Author     : gabriela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.min.js"></script>
        <script src="BuscaPergunta.js"></script>
        <link href="resources/bootstrap-theme.css" rel="stylesheet" />
        <link href="resources/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="resources/bootstrap.css" rel="stylesheet" />
        <link href="resources/bootstrap.min.css" rel="stylesheet" />
        <link href="resources/style.css" rel="stylesheet"/>
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
