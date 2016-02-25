'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('drinkrecipe', {
                parent: 'entity',
                url: '/drinkrecipes',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Drinkrecipes'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/drinkrecipe/drinkrecipes.html',
                        controller: 'DrinkrecipeController'
                    }
                },
                resolve: {
                }
            })
            .state('drinkrecipe.detail', {
                parent: 'entity',
                url: '/drinkrecipe/{id}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'Drinkrecipe'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/drinkrecipe/drinkrecipe-detail.html',
                        controller: 'DrinkrecipeDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Drinkrecipe', function($stateParams, Drinkrecipe) {
                        return Drinkrecipe.get({id : $stateParams.id});
                    }]
                }
            })
            .state('drinkrecipe.new', {
                parent: 'drinkrecipe',
                url: '/new',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkrecipe/drinkrecipe-dialog.html',
                        controller: 'DrinkrecipeDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    drinkname: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('drinkrecipe', null, { reload: true });
                    }, function() {
                        $state.go('drinkrecipe');
                    })
                }]
            })
            .state('drinkrecipe.edit', {
                parent: 'drinkrecipe',
                url: '/{id}/edit',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkrecipe/drinkrecipe-dialog.html',
                        controller: 'DrinkrecipeDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Drinkrecipe', function(Drinkrecipe) {
                                return Drinkrecipe.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('drinkrecipe', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('drinkrecipe.delete', {
                parent: 'drinkrecipe',
                url: '/{id}/delete',
                data: {
                    authorities: ['ROLE_USER'],
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkrecipe/drinkrecipe-delete-dialog.html',
                        controller: 'DrinkrecipeDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Drinkrecipe', function(Drinkrecipe) {
                                return Drinkrecipe.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('drinkrecipe', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
