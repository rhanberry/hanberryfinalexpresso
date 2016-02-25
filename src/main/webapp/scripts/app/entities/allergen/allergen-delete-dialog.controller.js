'use strict';

angular.module('finaltestApp')
	.controller('AllergenDeleteController', function($scope, $uibModalInstance, entity, Allergen) {

        $scope.allergen = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Allergen.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
