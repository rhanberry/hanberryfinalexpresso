'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('unitofmeasure', {
                parent: 'entity',
                url: '/unitofmeasures',
                data: {
                    pageTitle: 'Unitofmeasures'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/unitofmeasure/unitofmeasures.html',
                        controller: 'UnitofmeasureController'
                    }
                },
                resolve: {
                }
            })
            .state('unitofmeasure.detail', {
                parent: 'entity',
                url: '/unitofmeasure/{id}',
                data: {
                    pageTitle: 'Unitofmeasure'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/unitofmeasure/unitofmeasure-detail.html',
                        controller: 'UnitofmeasureDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Unitofmeasure', function($stateParams, Unitofmeasure) {
                        return Unitofmeasure.get({id : $stateParams.id});
                    }]
                }
            })
            .state('unitofmeasure.new', {
                parent: 'unitofmeasure',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitofmeasure/unitofmeasure-dialog.html',
                        controller: 'UnitofmeasureDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    unit: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('unitofmeasure', null, { reload: true });
                    }, function() {
                        $state.go('unitofmeasure');
                    })
                }]
            })
            .state('unitofmeasure.edit', {
                parent: 'unitofmeasure',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitofmeasure/unitofmeasure-dialog.html',
                        controller: 'UnitofmeasureDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Unitofmeasure', function(Unitofmeasure) {
                                return Unitofmeasure.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('unitofmeasure', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('unitofmeasure.delete', {
                parent: 'unitofmeasure',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/unitofmeasure/unitofmeasure-delete-dialog.html',
                        controller: 'UnitofmeasureDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Unitofmeasure', function(Unitofmeasure) {
                                return Unitofmeasure.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('unitofmeasure', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
