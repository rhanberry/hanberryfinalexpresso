'use strict';

angular.module('finaltestApp')
	.controller('IngredientsDeleteController', function($scope, $uibModalInstance, entity, Ingredients) {

        $scope.ingredients = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Ingredients.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
