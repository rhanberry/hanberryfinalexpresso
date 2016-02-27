'use strict';

angular.module('expressoApp')
    .controller('BakedGoodDetailController', function ($scope, $rootScope, $stateParams, entity, BakedGood, BakeryCategory, Vendor, Allergens) {
        $scope.bakedGood = entity;
        $scope.load = function (id) {
            BakedGood.get({id: id}, function(result) {
                $scope.bakedGood = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:bakedGoodUpdate', function(event, result) {
            $scope.bakedGood = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
