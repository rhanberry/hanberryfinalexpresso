'use strict';

angular.module('finaltestApp').controller('VendorDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Vendor', 'Bakedgood',
        function($scope, $stateParams, $uibModalInstance, entity, Vendor, Bakedgood) {

        $scope.vendor = entity;
        $scope.bakedgoods = Bakedgood.query();
        $scope.load = function(id) {
            Vendor.get({id : id}, function(result) {
                $scope.vendor = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:vendorUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.vendor.id != null) {
                Vendor.update($scope.vendor, onSaveSuccess, onSaveError);
            } else {
                Vendor.save($scope.vendor, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
