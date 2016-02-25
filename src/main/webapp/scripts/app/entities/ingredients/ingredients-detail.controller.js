'use strict';

angular.module('finaltestApp')
    .controller('IngredientsDetailController', function ($scope, $rootScope, $stateParams, entity, Ingredients, Unitofmeasure, Drinkrecipe) {
        $scope.ingredients = entity;
        $scope.load = function (id) {
            Ingredients.get({id: id}, function(result) {
                $scope.ingredients = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:ingredientsUpdate', function(event, result) {
            $scope.ingredients = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
