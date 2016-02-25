'use strict';

angular.module('finaltestApp')
    .controller('AllergensController', function ($scope, $state, Allergens) {

        $scope.allergenss = [];
        $scope.loadAll = function() {
            Allergens.query(function(result) {
               $scope.allergenss = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.allergens = {
                allergens: null,
                id: null
            };
        };
    });
