'use strict';

angular.module('finaltestApp')
	.controller('BakedgoodDeleteController', function($scope, $uibModalInstance, entity, Bakedgood) {

        $scope.bakedgood = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Bakedgood.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
