'use strict';

angular.module('expressoApp')
    .controller('AllergensDetailController', function ($scope, $rootScope, $stateParams, entity, Allergens, BakedGood) {
        $scope.allergens = entity;
        $scope.load = function (id) {
            Allergens.get({id: id}, function(result) {
                $scope.allergens = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:allergensUpdate', function(event, result) {
            $scope.allergens = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
