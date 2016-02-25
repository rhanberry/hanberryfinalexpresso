'use strict';

angular.module('finaltestApp')
	.controller('UnitofmeasureDeleteController', function($scope, $uibModalInstance, entity, Unitofmeasure) {

        $scope.unitofmeasure = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Unitofmeasure.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
