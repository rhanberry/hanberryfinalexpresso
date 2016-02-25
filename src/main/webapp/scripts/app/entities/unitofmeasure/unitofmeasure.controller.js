'use strict';

angular.module('finaltestApp')
    .controller('UnitofmeasureController', function ($scope, $state, Unitofmeasure) {

        $scope.unitofmeasures = [];
        $scope.loadAll = function() {
            Unitofmeasure.query(function(result) {
               $scope.unitofmeasures = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.unitofmeasure = {
                unit: null,
                id: null
            };
        };
    });
