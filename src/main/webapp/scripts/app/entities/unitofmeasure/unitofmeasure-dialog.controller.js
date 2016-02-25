'use strict';

angular.module('finaltestApp').controller('UnitofmeasureDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Unitofmeasure', 'Ingredients',
        function($scope, $stateParams, $uibModalInstance, entity, Unitofmeasure, Ingredients) {

        $scope.unitofmeasure = entity;
        $scope.ingredientss = Ingredients.query();
        $scope.load = function(id) {
            Unitofmeasure.get({id : id}, function(result) {
                $scope.unitofmeasure = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:unitofmeasureUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.unitofmeasure.id != null) {
                Unitofmeasure.update($scope.unitofmeasure, onSaveSuccess, onSaveError);
            } else {
                Unitofmeasure.save($scope.unitofmeasure, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
