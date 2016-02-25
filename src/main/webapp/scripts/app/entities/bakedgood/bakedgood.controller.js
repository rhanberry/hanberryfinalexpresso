'use strict';

angular.module('finaltestApp')
    .controller('BakedgoodController', function ($scope, $state, Bakedgood) {

        $scope.bakedgoods = [];
        $scope.loadAll = function() {
            Bakedgood.query(function(result) {
               $scope.bakedgoods = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.bakedgood = {
                bakedgoodname: null,
                bakeryprice: null,
                id: null
            };
        };
    });
