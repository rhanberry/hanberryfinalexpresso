'use strict';

angular.module('expressoApp')
    .controller('BakeryCategoryDetailController', function ($scope, $rootScope, $stateParams, entity, BakeryCategory, BakedGood) {
        $scope.bakeryCategory = entity;
        $scope.load = function (id) {
            BakeryCategory.get({id: id}, function(result) {
                $scope.bakeryCategory = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:bakeryCategoryUpdate', function(event, result) {
            $scope.bakeryCategory = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
