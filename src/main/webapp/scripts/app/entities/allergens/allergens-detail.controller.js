'use strict';

angular.module('finaltestApp')
    .controller('AllergensDetailController', function ($scope, $rootScope, $stateParams, entity, Allergens, Bakedgood) {
        $scope.allergens = entity;
        $scope.load = function (id) {
            Allergens.get({id: id}, function(result) {
                $scope.allergens = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:allergensUpdate', function(event, result) {
            $scope.allergens = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
