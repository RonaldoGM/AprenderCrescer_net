myApp.controller('UsuarioController'), function UsuarioController($scope, $http) {

    $scope.dados = [{"idUsuario": 1, "idGrupo": 1, "login": "ronaldo", "nome": "Ronaldo Gottardo de Meira", "flagInativo": 'F'}];

    $scope.buscaUsuarios = function () {
        UsuarioFactory.getUsuarios();
    }

    $scope.callbackUsuarios = function () {
        $scope.dados = resposta.data;
    }
};
