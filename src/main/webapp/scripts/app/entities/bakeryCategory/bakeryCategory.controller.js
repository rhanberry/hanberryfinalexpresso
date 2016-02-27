'use strict';

angular.module('expressoApp')
    .controller('BakeryCategoryController', function ($scope, $state, BakeryCategory) {

        $scope.bakeryCategorys = [];
        $scope.loadAll = function() {
            BakeryCategory.query(function(result) {
               $scope.bakeryCategorys = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.bakeryCategory = {
                bakeryCategory: null,
                id: null
            };
        };
    });
