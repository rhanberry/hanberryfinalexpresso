'use strict';

angular.module('expressoApp')
    .controller('UnitOfMeasureController', function ($scope, $state, UnitOfMeasure) {

        $scope.unitOfMeasures = [];
        $scope.loadAll = function() {
            UnitOfMeasure.query(function(result) {
               $scope.unitOfMeasures = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.unitOfMeasure = {
                unitOfMeasure: null,
                id: null
            };
        };
    });
