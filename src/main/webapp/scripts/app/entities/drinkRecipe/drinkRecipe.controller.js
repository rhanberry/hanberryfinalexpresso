'use strict';

angular.module('expressoApp')
    .controller('DrinkRecipeController', function ($scope, $state, DrinkRecipe) {

        $scope.drinkRecipes = [];
        $scope.loadAll = function() {
            DrinkRecipe.query(function(result) {
               $scope.drinkRecipes = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.drinkRecipe = {
                drinkRecipe: null,
                id: null
            };
        };
    });
