'use strict';

angular.module('expressoApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('bakedGood', {
                parent: 'entity',
                url: '/bakedGoods',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'BakedGoods'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/bakedGood/bakedGoods.html',
                        controller: 'BakedGoodController'
                    }
                },
                resolve: {
                }
            })
            .state('bakedGood.detail', {
                parent: 'entity',
                url: '/bakedGood/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'BakedGood'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/bakedGood/bakedGood-detail.html',
                        controller: 'BakedGoodDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'BakedGood', function($stateParams, BakedGood) {
                        return BakedGood.get({id : $stateParams.id});
                    }]
                }
            })
            .state('bakedGood.new', {
                parent: 'bakedGood',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedGood/bakedGood-dialog.html',
                        controller: 'BakedGoodDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    bakedGood: null,
                                    bakedGoodCost: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('bakedGood', null, { reload: true });
                    }, function() {
                        $state.go('bakedGood');
                    })
                }]
            })
            .state('bakedGood.edit', {
                parent: 'bakedGood',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedGood/bakedGood-dialog.html',
                        controller: 'BakedGoodDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['BakedGood', function(BakedGood) {
                                return BakedGood.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakedGood', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('bakedGood.delete', {
                parent: 'bakedGood',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedGood/bakedGood-delete-dialog.html',
                        controller: 'BakedGoodDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['BakedGood', function(BakedGood) {
                                return BakedGood.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakedGood', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
