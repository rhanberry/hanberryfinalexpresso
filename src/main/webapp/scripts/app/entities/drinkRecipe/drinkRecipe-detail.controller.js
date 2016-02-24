'use strict';

angular.module('finaltestApp')
    .controller('DrinkRecipeDetailController', function ($scope, $rootScope, $stateParams, entity, DrinkRecipe, Ingredients) {
        $scope.drinkRecipe = entity;
        $scope.load = function (id) {
            DrinkRecipe.get({id: id}, function(result) {
                $scope.drinkRecipe = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:drinkRecipeUpdate', function(event, result) {
            $scope.drinkRecipe = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });