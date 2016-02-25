'use strict';

angular.module('finaltestApp')
	.controller('CategoryDeleteController', function($scope, $uibModalInstance, entity, Category) {

        $scope.category = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Category.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
