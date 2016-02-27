'use strict';

angular.module('expressoApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('allergens', {
                parent: 'entity',
                url: '/allergenss',
                data: {
                    pageTitle: 'Allergenss'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/allergens/allergenss.html',
                        controller: 'AllergensController'
                    }
                },
                resolve: {
                }
            })
            .state('allergens.detail', {
                parent: 'entity',
                url: '/allergens/{id}',
                data: {
                    pageTitle: 'Allergens'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/allergens/allergens-detail.html',
                        controller: 'AllergensDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Allergens', function($stateParams, Allergens) {
                        return Allergens.get({id : $stateParams.id});
                    }]
                }
            })
            .state('allergens.new', {
                parent: 'allergens',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergens/allergens-dialog.html',
                        controller: 'AllergensDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    allergen: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('allergens', null, { reload: true });
                    }, function() {
                        $state.go('allergens');
                    })
                }]
            })
            .state('allergens.edit', {
                parent: 'allergens',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergens/allergens-dialog.html',
                        controller: 'AllergensDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Allergens', function(Allergens) {
                                return Allergens.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('allergens', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('allergens.delete', {
                parent: 'allergens',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergens/allergens-delete-dialog.html',
                        controller: 'AllergensDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Allergens', function(Allergens) {
                                return Allergens.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('allergens', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
