'use strict';

angular.module('expressoApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('unitOfMeasure', {
                parent: 'entity',
                url: '/unitOfMeasures',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'UnitOfMeasures'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/unitOfMeasure/unitOfMeasures.html',
                        controller: 'UnitOfMeasureController'
                    }
                },
                resolve: {
                }
            })
            .state('unitOfMeasure.detail', {
                parent: 'entity',
                url: '/unitOfMeasure/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'UnitOfMeasure'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/unitOfMeasure/unitOfMeasure-detail.html',
                        controller: 'UnitOfMeasureDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'UnitOfMeasure', function($stateParams, UnitOfMeasure) {
                        return UnitOfMeasure.get({id : $stateParams.id});
                    }]
                }
            })
            .state('unitOfMeasure.new', {
                parent: 'unitOfMeasure',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitOfMeasure/unitOfMeasure-dialog.html',
                        controller: 'UnitOfMeasureDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    unitOfMeasure: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('unitOfMeasure', null, { reload: true });
                    }, function() {
                        $state.go('unitOfMeasure');
                    })
                }]
            })
            .state('unitOfMeasure.edit', {
                parent: 'unitOfMeasure',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitOfMeasure/unitOfMeasure-dialog.html',
                        controller: 'UnitOfMeasureDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['UnitOfMeasure', function(UnitOfMeasure) {
                                return UnitOfMeasure.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('unitOfMeasure', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('unitOfMeasure.delete', {
                parent: 'unitOfMeasure',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitOfMeasure/unitOfMeasure-delete-dialog.html',
                        controller: 'UnitOfMeasureDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['UnitOfMeasure', function(UnitOfMeasure) {
                                return UnitOfMeasure.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('unitOfMeasure', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
