'use strict';

angular.module('finaltestApp')
	.controller('DrinkrecipeDeleteController', function($scope, $uibModalInstance, entity, Drinkrecipe) {

        $scope.drinkrecipe = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Drinkrecipe.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
