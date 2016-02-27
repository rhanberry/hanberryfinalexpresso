'use strict';

angular.module('expressoApp')
	.controller('BakeryCategoryDeleteController', function($scope, $uibModalInstance, entity, BakeryCategory) {

        $scope.bakeryCategory = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            BakeryCategory.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
