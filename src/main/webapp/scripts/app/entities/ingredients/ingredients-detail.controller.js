'use strict';

angular.module('expressoApp')
    .controller('IngredientsDetailController', function ($scope, $rootScope, $stateParams, entity, Ingredients, UnitOfMeasure, DrinkRecipe) {
        $scope.ingredients = entity;
        $scope.load = function (id) {
            Ingredients.get({id: id}, function(result) {
                $scope.ingredients = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:ingredientsUpdate', function(event, result) {
            $scope.ingredients = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
