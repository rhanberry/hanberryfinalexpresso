'use strict';

angular.module('finaltestApp')
    .controller('VendorController', function ($scope, $state, Vendor) {

        $scope.vendors = [];
        $scope.loadAll = function() {
            Vendor.query(function(result) {
               $scope.vendors = result;
            });
        };
        $scope.loadAll();


        $scope.refresh = function () {
            $scope.loadAll();
            $scope.clear();
        };

        $scope.clear = function () {
            $scope.vendor = {
                vendorname: null,
                id: null
            };
        };
    });
