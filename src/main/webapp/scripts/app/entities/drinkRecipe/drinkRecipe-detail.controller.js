'use strict';

angular.module('finaltestApp')
    .controller('DrinkrecipeDetailController', function ($scope, $rootScope, $stateParams, entity, Drinkrecipe, Ingredients) {
        $scope.drinkrecipe = entity;
        $scope.load = function (id) {
            Drinkrecipe.get({id: id}, function(result) {
                $scope.drinkrecipe = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:drinkrecipeUpdate', function(event, result) {
            $scope.drinkrecipe = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
