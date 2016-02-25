'use strict';

angular.module('finaltestApp')
    .controller('AllergenController', function ($scope, $state, Allergen) {

        $scope.allergens = [];
        $scope.loadAll = function() {
            Allergen.query(function(result) {
               $scope.allergens = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.allergen = {
                allergenname: null,
                id: null
            };
        };
    });
