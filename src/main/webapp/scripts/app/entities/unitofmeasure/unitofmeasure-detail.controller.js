'use strict';

angular.module('finaltestApp')
    .controller('UnitofmeasureDetailController', function ($scope, $rootScope, $stateParams, entity, Unitofmeasure, Ingredients) {
        $scope.unitofmeasure = entity;
        $scope.load = function (id) {
            Unitofmeasure.get({id: id}, function(result) {
                $scope.unitofmeasure = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:unitofmeasureUpdate', function(event, result) {
            $scope.unitofmeasure = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
