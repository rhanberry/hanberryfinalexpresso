'use strict';

angular.module('finaltestApp')
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
                ingredientname: null,
                ingredientprice: null,
                ingredientunit: null,
                id: null
            };
        };
    });
