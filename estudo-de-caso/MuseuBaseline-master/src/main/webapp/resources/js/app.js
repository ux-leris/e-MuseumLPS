angular.module('app', ['ngRoute', 'ngResource', 'ngAnimate', 'ui.bootstrap'])
        .constant('user', {points : 0}) 
        .constant('perg1Disabled', {state: false})
        .constant('perg2Disabled', {state: false})
        .constant('perg3Disabled', {state: false}) 
        .constant('perg4Disabled', {state: false})   
        .constant('navegaDesafios', {state: false})   
        .constant('contGuia', {cont: 0, contD: 0})  
        .constant('galeryImages', {images : [], desafios: []})
        .config(['$routeProvider', '$compileProvider',
  function($routeProvider, $compileProvider) {
      
        $compileProvider.debugInfoEnabled(false);
     console.log($routeProvider);
    
  }])
  .controller('TestController', ['$scope', '$location', function($scope, $location){
          alert($location.url);
  }])
      .controller('MainController', ['$scope', '$location', function($scope, $location){
          $scope.redirectDesafios = redirectDesafios;
          $scope.redirectGaleria = redirectGaleria;
          
          function redirectDesafios(){
              
              $location.path("desafios");
          }
          
          function redirectGaleria(){
              console.log($location.url())
              $location.path("galeria");
          }
         
  }])
    .controller('GalleryController', ['$scope', '$modal', 'contGuia', 'galeryImages', '$rootScope', '$location', '$window' ,'navegaDesafios', 
    function($scope, $modal, contGuia, galeryImages, $rootScope, $location, $window, navegaDesafios){
        
        var opened = false;
         var dOpened = false;
        
        var location = $window.location.pathname.split('/'); 
        if(location[location.length-1] == 'tour'){ opened = true;  
            console.log("open");
        }
        
        if(location[location.length-1] == 'desafios'){ dOpened = true;  
            console.log("open");
        }
                           
        console.log("oi");
            $scope.initList = initList;
            $scope.checkOpened = checkOpened;
          var cont = 0 ;
          var des = 0;
          var images = [];
          
           $rootScope.$on("OpenTour", function(){
                openTour();
             });
             
             $rootScope.$on("OpenDesafios", function(){
                openDesafios();
             });
 
            function checkOpened(){
                
                 var desafios = [];
                 angular.forEach(galeryImages.images, function(value, key){
                    console.log(des + value.name)
                    var desafio = {id:des ,url: value.url, name : value.name } 
                    desafios.push(desafio);
                    des++;
                });
                galeryImages.desafios = desafios;
                
                if(opened){
                    
                 navegaDesafios.state = false;
                    openTour();
                } else if (dOpened){
                     navegaDesafios.state = true;
                    console.log("hi")
                    openDesafios();
                }
            }
            function initList(url, text, name){
                console.log("init");
             var image = {url: url, text:text, name:name, id:cont, comments:[]} ;
              images.push(image);
              cont += 1; 
             galeryImages.images = images;
              
          }
          
          $scope.openTour = openTour;
          
        function openTour(){
            
                 navegaDesafios.state = false;
              console.log("openTour" + galeryImages.images.length);
              angular.forEach(galeryImages.images, function(value, key){
                if(value.id == contGuia.cont){
                  console.log("log");
                  openImage('/MuseuBaseline/resources/' + value.url, '', value.name, 'lg');
               }
            });
          };
          
          $scope.openDesafios = openDesafios;
                
          function openDesafios(){ 
                 navegaDesafios.state = true;
                 console.log("oi" +  galeryImages.desafios)
                  angular.forEach(galeryImages.desafios, function(value, key){
                      
                 console.log("oi" + value.id + " " + contGuia.contD)
                        if(value.id == contGuia.contD){
                          console.log("log");
                          $scope.openDesafio('/MuseuBaseline/resources/' + value.url, value.name);
                       }
                    });
          }
          
          $scope.openDesafio = function(url, name){
                 navegaDesafios.state = true;
               var modalInstance = $modal.open({
               animation: $scope.animationsEnabled,
               size:'lg', 
               templateUrl: 'myModalDesafio.html', 
               controller: 'DesafioController', 
               resolve: {
                   image: function(){
                       return url;
                   },
                   name: function(){
                       return name;
                   }
               }
               
             });
          };
          
          $scope.openImage = openImage;
              
            
            function openImage(img, text, name, size){
                 navegaDesafios.state = false;
            console.log("open" + img);
            angular.forEach(galeryImages.images, function(value, key){
                if(value.name == name){
                  contGuia.cont = value.id;
               }
            });
            var modalInstance = $modal.open({
               animation: $scope.animationsEnabled,
               size:size, 
               templateUrl: 'myModalContent.html', 
               controller: 'ModalController', 
               resolve: {
                   image: function(){
                       return img;
                   },
                   text: function(){
                       return text;
                   },
                   name: function(){
                       return name;
                   }
               }
             });
             
             
           }
   }])
       .controller('MainCtrl', function ($scope) {
        $scope.centerAnchor = true;
        $scope.toggleCenterAnchor = function () {$scope.centerAnchor = !$scope.centerAnchor}
        $scope.draggableObjects = [{name:'one'}, {name:'two'}, {name:'three'}];
        $scope.droppedObjects1 = [];
        $scope.droppedObjects2= [];
        $scope.onDropComplete1=function(data,evt){
            var index = $scope.droppedObjects1.indexOf(data);
            if (index == -1)
            $scope.droppedObjects1.push(data);
        }
        $scope.onDragSuccess1=function(data,evt){
            console.log("133","$scope","onDragSuccess1", "", evt);
            var index = $scope.droppedObjects1.indexOf(data);
            if (index > -1) {
                $scope.droppedObjects1.splice(index, 1);
            }
        }
        $scope.onDragSuccess2=function(data,evt){
            var index = $scope.droppedObjects2.indexOf(data);
            if (index > -1) {
                $scope.droppedObjects2.splice(index, 1);
            }
        }
        $scope.onDropComplete2=function(data,evt){
            var index = $scope.droppedObjects2.indexOf(data);
            if (index == -1) {
                $scope.droppedObjects2.push(data);
            }
        }
        var inArray = function(array, obj) {
            var index = array.indexOf(obj);
        }
      })
   .controller('ModalController', ['$scope', 'image', '$modalInstance', '$modal', 'text', 'name', 'contGuia', 'galeryImages', '$rootScope',  
       function($scope, image, $modalInstance, $modal, text, name,contGuia, galeryImages, $rootScope){
          
          $scope.title = name;
          $scope.image = image;
          $scope.text = text;
          
          
          $scope.comments = galeryImages.images[contGuia.cont].comments;
          
          $scope.leaveComment = function(){
              if( $scope.user.comment != null &&  $scope.user.comment != "")
              $scope.comments.push({name: "Anônimo",comment: $scope.user.comment});
              $scope.user.comment = null;
              galeryImages.images[contGuia.cont].comments = $scope.comments;
          };
          
          $scope.contZero = contGuia.cont == 0;
          $scope.contFull = contGuia.cont == galeryImages.images.length-1;
          
          if($scope.contFull) contGuia.cont = 0;
          
          $scope.prev = function(){
              contGuia.cont--;
              closeModal();
              
             $rootScope.$emit("OpenTour", {});
          };
          
          $scope.next = function(){
              contGuia.cont++;
              closeModal();
             $rootScope.$emit("OpenTour", {});
          };
   
          
          $scope.openSecondModal = function(){
               var modalInstance = $modal.open({
               animation: $scope.animationsEnabled,
               size:'lg', 
               templateUrl: 'myModalDesafio.html', 
               controller: 'DesafioController', 
               resolve: {
                   image: function(){
                       return image;
                   },
                   name: function(){
                       return name;
                   }
               }
               
             });
          };
          
          changeText();
          
          function changeText(){
              console.log("changeText" 
                      + name)
              switch(name.trim()){
                  case "O Palácio do Catete":
                      $scope.text = "O Museu da República fica localizado no Palácio do Catete, no Rio de Janeiro. Foi sede do poder executivo brasileiro de 1897 a 1960. A partir dessa data, foi transferida para Brasília.";

                  break;
                  case "A Pátria":
                      $scope.text = "O quadro 'A Pátria' retrata o nascimento da República. Para tanto, Pedro Bruno usa diversos recursos, dentre os quais temos mulheres, que remetem à Marianne (símbolo da Revolução Francesa), e a criança segurando a bandeira, que representa o futuro.";

                break;
                  case "O quarto de Vargas":

                      $scope.text = "Getúlio Vargas governou o Brasil entre 1930 e 1945, período conhecido como Era Vargas, que compreende a Segunda e Terceira República. Mudando o rumo da história, Vargas se matou em se quarto, em 24 de agosto de 1954.";
                  break;
                  case "O Salão Nobre":

                      $scope.text = "O Salão Nobre relembra a vida social e o luxo da corte. Como sede da Presidência, recebeu sobre as portas as Armas da República. Em 1938, o painel do teto foi refeito pelo pintor acadêmico brasileiro Armando Vianna.";
                  break;
              default: 
                  $scope.text = "";
              }
          }
          
          $scope.closeModal = closeModal;
                  
           function closeModal(){
                $modalInstance.dismiss('closeModal');
           }
   }])
   .controller('DesafioController', ['$scope',  '$modalInstance', '$modal', 'image', 'name', 'user', 'perg1Disabled', 'navegaDesafios', 
    'perg2Disabled', 'perg3Disabled', 'perg4Disabled','contGuia', 'galeryImages', '$rootScope', 
       function($scope, $modalInstance, $modal, image, name, user, perg1Disabled, navegaDesafios, perg2Disabled, perg3Disabled, perg4Disabled, contGuia, galeryImages, $rootScope){
            $scope.centerAnchor = true;
        $scope.toggleCenterAnchor = function () {$scope.centerAnchor = !$scope.centerAnchor}
           $scope.respostasDisabled = false;
          $scope.resp1model = false;
          $scope.resp2model = false;
          $scope.resp3model = false;
          $scope.resp4model = false;
          $scope.draggableDiv = false;
          $scope.perguntaImagem = false; 
          $scope.navegaDesafios =  navegaDesafios.state;
         
          $scope.perguntaTeorica = false; 
          $scope.alertmsg = "Resposta correta";
          $scope.alerttype = "alert alert-danger"
           $scope.image = image;
           $scope.imageResp = '/MuseuBaseline/resources/imgs/drag-and-drop.png';
        $scope.showAlert = true; 
        $scope.respostaCorreta = false;
          $scope.name = name;
          $scope.contZero =  contGuia.contD == 0;
          $scope.contFull = contGuia.contD == galeryImages.desafios.length-1;
          
          if($scope.contFull) contGuia.contD = 0;
          
          $scope.prev = function(){
              contGuia.contD = contGuia.contD-1;
              closeModal();
              console.log(contGuia.contD)
             $rootScope.$emit("OpenDesafios", {});
          };
          
          $scope.next = function(){
              contGuia.contD = contGuia.contD+1;
              closeModal();
             $rootScope.$emit("OpenDesafios", {});
          };
          
          
           $scope.onDragComplete=function(data,evt){
                console.log("drag success, data:", data);
             }
             $scope.onDropComplete=function(data,evt){
                 console.log("drop success, data:", data);
             }
            
          
          $scope.closeModal = function(){
                $modalInstance.dismiss('closeModal');
           };
           $scope.points = 0;
           
          changeText();
          
          function changeText(){
              switch(name.trim()){
                  case "O Palácio do Catete":
                      $scope.question = "Associe a imagem do Palácio do Catete à atual sede do poder executivo brasileiro.";
                      $scope.resp1 = "/MuseuBaseline/resources/imgs/image02.jpg";
                      $scope.resp4 = "/MuseuBaseline/resources/imgs/image01.jpg";
                      $scope.resp3 = "/MuseuBaseline/resources/imgs/image03.jpg";
                      $scope.resp2 = "/MuseuBaseline/resources/imgs/resp006.jpg";
                      $scope.respostasDisabled = perg1Disabled.state;
                      $scope.respostaCorreta = perg1Disabled.state;
                      $scope.perguntaTeorica = false; 
                      $scope.perguntaImagem = true; 
                  break;
                  case "A Pátria":
                      $scope.question = "Associe o quadro ‘A Pátria’ à imagem que mais se assemelha ao seu significado.";
                      $scope.resp1 = "/MuseuBaseline/resources/imgs/image00.jpg";
                      $scope.resp4 = "/MuseuBaseline/resources/imgs/image04.jpg";
                      $scope.resp3 = "/MuseuBaseline/resources/imgs/image05.jpg";
                      $scope.resp2 = "/MuseuBaseline/resources/imgs/resp005.jpg";
                      $scope.respostasDisabled = perg2Disabled.state;
                      $scope.respostaCorreta = perg2Disabled.state;
                      $scope.perguntaTeorica = false; 
                      $scope.perguntaImagem = true; 
                  break;
                  case "O quarto de Vargas":
                      $scope.question = " Quantos anos Vargas ficou no poder?";
                      $scope.resp1 = "11 anos";
                      $scope.resp2 = "12 anos";
                      $scope.resp3 = "13 anos";
                      $scope.resp4 = "15 anos";
                      $scope.respostasDisabled = perg3Disabled.state;
                      $scope.respostaCorreta = perg3Disabled.state;
                      $scope.perguntaTeorica = true; 
                      $scope.perguntaImagem = false; 
                  break;
                  case "O Salão Nobre":
                      $scope.question = " O piso das principais recepções do Palácio do Catete, posterior sede da Presidência, era caracterizado por:";
                      $scope.resp1 = "simplicidade";
                      $scope.resp2 = "humildade";
                      $scope.resp3 = "informalidade";
                      $scope.resp4 = "nobreza";
                      $scope.respostasDisabled = perg4Disabled.state;
                      $scope.respostaCorreta = perg4Disabled.state;
                      
                      $scope.perguntaTeorica = true; 
                      $scope.perguntaImagem = false; 
                      console.log("pergunta" + $scope.perguntaImagem);
                  break;
              default: 
                  $scope.question = "";
              }
              if($scope.respostasDisabled){
                    $scope.showAlert = false; 
                  $scope.alertmsg = "Você já respondeu corretamente a essa questão";
                 $scope.alerttype = "alert alert-warning";
              }
          }
      
           $scope.confereRespostas = function(){
               console.log(perg4Disabled.state)
               if($scope.resp4model && !$scope.respostasDisabled) { 
                    $scope.showAlert = false; 
                    user.points += 10;
                    $scope.alertmsg = "Sua resposta está correta, parabéns! Sua pontuação é " + user.points;
                    $scope.alerttype = "alert alert-success";
                    $scope.respostaCorreta = true;
                    $scope.respostasDisabled = true;
                    switch(name.trim()){
                            case "O Palácio do Catete":
                                perg1Disabled.state = true;
                                console.log(perg1Disabled.state);
                            break;
                            case "A Pátria":
                                perg2Disabled.state = true;
                            break;
                            case "O quarto de Vargas":
                                perg3Disabled.state = true;
                            break;
                            case "O Salão Nobre": 
                                console.log("changePerg3")
                                perg4Disabled.state = true;
                                break;
                        }
                    
                    
                } else if(!$scope.respostasDisabled){ 
                    $scope.showAlert = false; 
                    $scope.alertmsg = "Sua resposta está incorreta, tente novamente!";
                    $scope.alerttype = "alert alert-danger";
                    user.points -= 1;
                    $scope.respostaCorreta = false;
                }
                console.log($scope.respostaCorreta + " " + perg4Disabled.state)
           }
           
           $scope.closeModal = closeModal;
                  
           function closeModal(){
                $modalInstance.dismiss('closeModal');
           }
           
   }])
   .controller('AboutCtrl', function ($scope, $location) {
       
      })
      .controller('QuestionsCtrl', function ($scope, $location, $resource) {
       $scope.nome = "";
       $scope.pergunta = "";
       
        $scope.perguntas = [
        {
            nome:'Daniel',
            data: '12/08/2015',
            pergunta: 'Quando Getúlio Vargas Morreu?',
            resposta: 'Em 24 de agosto de 1954'
        },
        {
            nome:'Joana',
            data:'15/11/2015',
            pergunta:'Como é o nome do museu mesmo?',
            resposta:'Museu da República'
        }
    ];
       
       var emailRequest = $resource("/MuseuBaseline/object/email");
       
       
       console.log("oi");
       $scope.enviarPergunta = function(){
           var d = new Date();
           if($scope.pergunta != "" && $scope.nome != "")
           $scope.perguntas.push({"nome" : $scope.nome, "pergunta" : $scope.pergunta, "resposta" : "Aguardando resposta do professor...", "data" : d.getDate() + "/" + d.getMonth() + "/" + d.getFullYear()});
           
        emailRequest.save( {name:$scope.nome, pergunta: $scope.pergunta})
           console.log($scope.perguntas);
           $scope.nome="";
           $scope.pergunta="";
       };
      });
