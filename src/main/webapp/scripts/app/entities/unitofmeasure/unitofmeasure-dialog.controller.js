'use strict';

angular.module('expressoApp').controller('UnitOfMeasureDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'UnitOfMeasure', 'Ingredients',
        function($scope, $stateParams, $uibModalInstance, entity, UnitOfMeasure, Ingredients) {

        $scope.unitOfMeasure = entity;
        $scope.ingredientss = Ingredients.query();
        $scope.load = function(id) {
            UnitOfMeasure.get({id : id}, function(result) {
                $scope.unitOfMeasure = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('expressoApp:unitOfMeasureUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.unitOfMeasure.id != null) {
                UnitOfMeasure.update($scope.unitOfMeasure, onSaveSuccess, onSaveError);
            } else {
                UnitOfMeasure.save($scope.unitOfMeasure, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
