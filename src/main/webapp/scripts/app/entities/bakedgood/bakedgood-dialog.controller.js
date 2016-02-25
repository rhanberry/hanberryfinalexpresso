'use strict';

angular.module('finaltestApp').controller('BakedgoodDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Bakedgood', 'Category', 'Vendor', 'Allergen',
        function($scope, $stateParams, $uibModalInstance, entity, Bakedgood, Category, Vendor, Allergen) {

        $scope.bakedgood = entity;
        $scope.categorys = Category.query();
        $scope.vendors = Vendor.query();
        $scope.allergens = Allergen.query();
        $scope.load = function(id) {
            Bakedgood.get({id : id}, function(result) {
                $scope.bakedgood = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:bakedgoodUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.bakedgood.id != null) {
                Bakedgood.update($scope.bakedgood, onSaveSuccess, onSaveError);
            } else {
                Bakedgood.save($scope.bakedgood, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
