'use strict'

myApp.factory('UsuarioFactory', ['$http',
    function ($http, UsuarioFactory) {

        return{
            getUsuarios: function (callback) {
                $http({"method": "GET",
                    "url": "/AprenderCrescet/hast/usuaruios/getusuarios"}).then(
                        function (resposta) {
                            callback(resposta);
                        });
            },
        };
    }]);