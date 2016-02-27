'use strict';

angular.module('expressoApp')
    .controller('BakedGoodController', function ($scope, $state, BakedGood) {

        $scope.bakedGoods = [];
        $scope.loadAll = function() {
            BakedGood.query(function(result) {
               $scope.bakedGoods = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.bakedGood = {
                bakedGood: null,
                bakedGoodCost: null,
                id: null
            };
        };
    });
