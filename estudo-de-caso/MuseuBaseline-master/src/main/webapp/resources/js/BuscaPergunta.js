var app = angular.module("buscaPerguntas",[]).
        controller("busca", busca);

busca.$inject = ['$scope'];

function busca($scope){
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
}


