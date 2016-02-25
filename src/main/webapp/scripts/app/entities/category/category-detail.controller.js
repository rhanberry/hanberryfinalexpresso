'use strict';

angular.module('finaltestApp')
    .controller('CategoryDetailController', function ($scope, $rootScope, $stateParams, entity, Category, Bakedgood) {
        $scope.category = entity;
        $scope.load = function (id) {
            Category.get({id: id}, function(result) {
                $scope.category = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:categoryUpdate', function(event, result) {
            $scope.category = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
