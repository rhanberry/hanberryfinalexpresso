'use strict';

angular.module('expressoApp').controller('VendorDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Vendor', 'BakedGood',
        function($scope, $stateParams, $uibModalInstance, entity, Vendor, BakedGood) {

        $scope.vendor = entity;
        $scope.bakedgoods = BakedGood.query();
        $scope.load = function(id) {
            Vendor.get({id : id}, function(result) {
                $scope.vendor = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('expressoApp:vendorUpdate', result);
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
