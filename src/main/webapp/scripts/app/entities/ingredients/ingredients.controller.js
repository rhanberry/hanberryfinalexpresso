'use strict';

angular.module('expressoApp')
    .controller('IngredientsController', function ($scope, $state, Ingredients) {

        $scope.ingredientss = [];
        $scope.loadAll = function() {
            Ingredients.query(function(result) {
               $scope.ingredientss = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.ingredients = {
                ingredient: null,
                ingredientCost: null,
                id: null
            };
        };
    });
