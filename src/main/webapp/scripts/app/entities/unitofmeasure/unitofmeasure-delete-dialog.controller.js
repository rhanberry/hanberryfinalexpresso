'use strict';

angular.module('expressoApp')
	.controller('UnitOfMeasureDeleteController', function($scope, $uibModalInstance, entity, UnitOfMeasure) {

        $scope.unitOfMeasure = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            UnitOfMeasure.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
