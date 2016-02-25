'use strict';

angular.module('finaltestApp')
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
                drinkname: null,
                id: null
            };
        };
    });
