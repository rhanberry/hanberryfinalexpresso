'use strict';

angular.module('expressoApp').controller('BakeryCategoryDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'BakeryCategory', 'BakedGood',
        function($scope, $stateParams, $uibModalInstance, entity, BakeryCategory, BakedGood) {

        $scope.bakeryCategory = entity;
        $scope.bakedgoods = BakedGood.query();
        $scope.load = function(id) {
            BakeryCategory.get({id : id}, function(result) {
                $scope.bakeryCategory = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('expressoApp:bakeryCategoryUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.bakeryCategory.id != null) {
                BakeryCategory.update($scope.bakeryCategory, onSaveSuccess, onSaveError);
            } else {
                BakeryCategory.save($scope.bakeryCategory, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
