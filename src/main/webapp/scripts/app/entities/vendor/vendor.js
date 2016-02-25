'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('vendor', {
                parent: 'entity',
                url: '/vendors',
                data: {
                    pageTitle: 'Vendors'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/vendor/vendors.html',
                        controller: 'VendorController'
                    }
                },
                resolve: {
                }
            })
            .state('vendor.detail', {
                parent: 'entity',
                url: '/vendor/{id}',
                data: {
                    pageTitle: 'Vendor'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/vendor/vendor-detail.html',
                        controller: 'VendorDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Vendor', function($stateParams, Vendor) {
                        return Vendor.get({id : $stateParams.id});
                    }]
                }
            })
            .state('vendor.new', {
                parent: 'vendor',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/vendor/vendor-dialog.html',
                        controller: 'VendorDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    vendorname: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('vendor', null, { reload: true });
                    }, function() {
                        $state.go('vendor');
                    })
                }]
            })
            .state('vendor.edit', {
                parent: 'vendor',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/vendor/vendor-dialog.html',
                        controller: 'VendorDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Vendor', function(Vendor) {
                                return Vendor.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('vendor', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('vendor.delete', {
                parent: 'vendor',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/vendor/vendor-delete-dialog.html',
                        controller: 'VendorDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Vendor', function(Vendor) {
                                return Vendor.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('vendor', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
