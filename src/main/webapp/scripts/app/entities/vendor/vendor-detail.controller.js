'use strict';

angular.module('expressoApp')
    .controller('VendorDetailController', function ($scope, $rootScope, $stateParams, entity, Vendor, BakedGood) {
        $scope.vendor = entity;
        $scope.load = function (id) {
            Vendor.get({id: id}, function(result) {
                $scope.vendor = result;
            });
        };
        var unsubscribe = $rootScope.$on('expressoApp:vendorUpdate', function(event, result) {
            $scope.vendor = result;
        });
        $scope.$on('$destroy', unsubscribe);

    });
