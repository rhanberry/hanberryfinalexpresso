'use strict';

angular.module('finaltestApp')
	.controller('VendorDeleteController', function($scope, $uibModalInstance, entity, Vendor) {

        $scope.vendor = entity;
        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
        $scope.confirmDelete = function (id) {
            Vendor.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        };

    });
