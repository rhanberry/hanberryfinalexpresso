'use strict';

angular.module('expressoApp')
	.controller('BakedGoodDeleteController', function($scope, $uibModalInstance, entity, BakedGood) {

        $scope.bakedGood = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            BakedGood.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
