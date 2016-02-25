'use strict';

angular.module('finaltestApp')
    .controller('DrinkrecipeController', function ($scope, $state, Drinkrecipe) {

        $scope.drinkrecipes = [];
        $scope.loadAll = function() {
            Drinkrecipe.query(function(result) {
               $scope.drinkrecipes = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.drinkrecipe = {
                drinkname: null,
                id: null
            };
        };
    });
