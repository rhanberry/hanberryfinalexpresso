'use strict';

angular.module('expressoApp')
    .controller('UnitOfMeasureDetailController', function ($scope, $rootScope, $stateParams, entity, UnitOfMeasure, Ingredients) {
        $scope.unitOfMeasure = entity;
        $scope.load = function (id) {
            UnitOfMeasure.get({id: id}, function(result) {
                $scope.unitOfMeasure = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:unitOfMeasureUpdate', function(event, result) {
            $scope.unitOfMeasure = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
