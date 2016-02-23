'use strict';

angular.module('finaltestApp')
	.controller('AllergensDeleteController', function($scope, $uibModalInstance, entity, Allergens) {

        $scope.allergens = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Allergens.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
