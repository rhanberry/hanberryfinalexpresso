'use strict';

angular.module('finaltestApp')
    .controller('AllergenDetailController', function ($scope, $rootScope, $stateParams, entity, Allergen, Bakedgood) {
        $scope.allergen = entity;
        $scope.load = function (id) {
            Allergen.get({id: id}, function(result) {
                $scope.allergen = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:allergenUpdate', function(event, result) {
            $scope.allergen = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
