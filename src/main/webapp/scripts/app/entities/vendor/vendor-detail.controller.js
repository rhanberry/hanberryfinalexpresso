'use strict';

angular.module('finaltestApp')
    .controller('VendorDetailController', function ($scope, $rootScope, $stateParams, entity, Vendor, Bakedgood) {
        $scope.vendor = entity;
        $scope.load = function (id) {
            Vendor.get({id: id}, function(result) {
                $scope.vendor = result;
            });
        };
        var unsubscribe = $rootScope.$on('finaltestApp:vendorUpdate', function(event, result) {
            $scope.vendor = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
