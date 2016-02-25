'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('bakedgood', {
                parent: 'entity',
                url: '/bakedgoods',
                data: {
                    pageTitle: 'Bakedgoods'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/bakedgood/bakedgoods.html',
                        controller: 'BakedgoodController'
                    }
                },
                resolve: {
                }
            })
            .state('bakedgood.detail', {
                parent: 'entity',
                url: '/bakedgood/{id}',
                data: {
                    pageTitle: 'Bakedgood'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/bakedgood/bakedgood-detail.html',
                        controller: 'BakedgoodDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Bakedgood', function($stateParams, Bakedgood) {
                        return Bakedgood.get({id : $stateParams.id});
                    }]
                }
            })
            .state('bakedgood.new', {
                parent: 'bakedgood',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedgood/bakedgood-dialog.html',
                        controller: 'BakedgoodDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    bakedgoodname: null,
                                    bakedgoodcost: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('bakedgood', null, { reload: true });
                    }, function() {
                        $state.go('bakedgood');
                    })
                }]
            })
            .state('bakedgood.edit', {
                parent: 'bakedgood',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedgood/bakedgood-dialog.html',
                        controller: 'BakedgoodDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Bakedgood', function(Bakedgood) {
                                return Bakedgood.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakedgood', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('bakedgood.delete', {
                parent: 'bakedgood',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakedgood/bakedgood-delete-dialog.html',
                        controller: 'BakedgoodDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Bakedgood', function(Bakedgood) {
                                return Bakedgood.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakedgood', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
