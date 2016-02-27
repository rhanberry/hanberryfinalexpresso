'use strict';

angular.module('expressoApp').controller('BakedGoodDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'BakedGood', 'BakeryCategory', 'Vendor', 'Allergens',
        function($scope, $stateParams, $uibModalInstance, entity, BakedGood, BakeryCategory, Vendor, Allergens) {

        $scope.bakedGood = entity;
        $scope.bakerycategorys = BakeryCategory.query();
        $scope.vendors = Vendor.query();
        $scope.allergenss = Allergens.query();
        $scope.load = function(id) {
            BakedGood.get({id : id}, function(result) {
                $scope.bakedGood = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('expressoApp:bakedGoodUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.bakedGood.id != null) {
                BakedGood.update($scope.bakedGood, onSaveSuccess, onSaveError);
            } else {
                BakedGood.save($scope.bakedGood, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
