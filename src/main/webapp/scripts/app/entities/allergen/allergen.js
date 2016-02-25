'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('allergen', {
                parent: 'entity',
                url: '/allergens',
                data: {
                    pageTitle: 'Allergens'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/allergen/allergens.html',
                        controller: 'AllergenController'
                    }
                },
                resolve: {
                }
            })
            .state('allergen.detail', {
                parent: 'entity',
                url: '/allergen/{id}',
                data: {
                    pageTitle: 'Allergen'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/allergen/allergen-detail.html',
                        controller: 'AllergenDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Allergen', function($stateParams, Allergen) {
                        return Allergen.get({id : $stateParams.id});
                    }]
                }
            })
            .state('allergen.new', {
                parent: 'allergen',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergen/allergen-dialog.html',
                        controller: 'AllergenDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    allergenname: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('allergen', null, { reload: true });
                    }, function() {
                        $state.go('allergen');
                    })
                }]
            })
            .state('allergen.edit', {
                parent: 'allergen',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergen/allergen-dialog.html',
                        controller: 'AllergenDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Allergen', function(Allergen) {
                                return Allergen.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('allergen', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('allergen.delete', {
                parent: 'allergen',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/allergen/allergen-delete-dialog.html',
                        controller: 'AllergenDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Allergen', function(Allergen) {
                                return Allergen.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('allergen', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
