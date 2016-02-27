'use strict';

angular.module('expressoApp').controller('AllergensDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Allergens', 'BakedGood',
        function($scope, $stateParams, $uibModalInstance, entity, Allergens, BakedGood) {

        $scope.allergens = entity;
        $scope.bakedgoods = BakedGood.query();
        $scope.load = function(id) {
            Allergens.get({id : id}, function(result) {
                $scope.allergens = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('expressoApp:allergensUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.allergens.id != null) {
                Allergens.update($scope.allergens, onSaveSuccess, onSaveError);
            } else {
                Allergens.save($scope.allergens, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
