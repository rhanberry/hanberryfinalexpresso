'use strict';

angular.module('finaltestApp')
	.controller('DrinkRecipeDeleteController', function($scope, $uibModalInstance, entity, DrinkRecipe) {

        $scope.drinkRecipe = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            DrinkRecipe.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
