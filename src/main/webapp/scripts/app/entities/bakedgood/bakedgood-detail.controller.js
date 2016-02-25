'use strict';

angular.module('finaltestApp')
    .controller('BakedgoodDetailController', function ($scope, $rootScope, $stateParams, entity, Bakedgood, Category, Vendor, Allergen) {
        $scope.bakedgood = entity;
        $scope.load = function (id) {
            Bakedgood.get({id: id}, function(result) {
                $scope.bakedgood = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:bakedgoodUpdate', function(event, result) {
            $scope.bakedgood = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
