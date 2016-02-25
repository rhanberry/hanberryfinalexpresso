'use strict';

angular.module('finaltestApp').controller('AllergenDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Allergen', 'Bakedgood',
        function($scope, $stateParams, $uibModalInstance, entity, Allergen, Bakedgood) {

        $scope.allergen = entity;
        $scope.bakedgoods = Bakedgood.query();
        $scope.load = function(id) {
            Allergen.get({id : id}, function(result) {
                $scope.allergen = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:allergenUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.allergen.id != null) {
                Allergen.update($scope.allergen, onSaveSuccess, onSaveError);
            } else {
                Allergen.save($scope.allergen, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
