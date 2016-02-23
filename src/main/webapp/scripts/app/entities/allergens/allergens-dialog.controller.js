'use strict';

angular.module('finaltestApp').controller('AllergensDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Allergens', 'Bakedgood',
        function($scope, $stateParams, $uibModalInstance, entity, Allergens, Bakedgood) {

        $scope.allergens = entity;
        $scope.bakedgoods = Bakedgood.query();
        $scope.load = function(id) {
            Allergens.get({id : id}, function(result) {
                $scope.allergens = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:allergensUpdate', result);
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
