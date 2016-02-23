'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('drinkRecipe', {
                parent: 'entity',
                url: '/drinkRecipes',
                data: {
                    pageTitle: 'DrinkRecipes'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/drinkRecipe/drinkRecipes.html',
                        controller: 'DrinkRecipeController'
                    }
                },
                resolve: {
                }
            })
            .state('drinkRecipe.detail', {
                parent: 'entity',
                url: '/drinkRecipe/{id}',
                data: {
                    pageTitle: 'DrinkRecipe'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/drinkRecipe/drinkRecipe-detail.html',
                        controller: 'DrinkRecipeDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'DrinkRecipe', function($stateParams, DrinkRecipe) {
                        return DrinkRecipe.get({id : $stateParams.id});
                    }]
                }
            })
            .state('drinkRecipe.new', {
                parent: 'drinkRecipe',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkRecipe/drinkRecipe-dialog.html',
                        controller: 'DrinkRecipeDialogController',
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
                        $state.go('drinkRecipe', null, { reload: true });
                    }, function() {
                        $state.go('drinkRecipe');
                    })
                }]
            })
            .state('drinkRecipe.edit', {
                parent: 'drinkRecipe',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkRecipe/drinkRecipe-dialog.html',
                        controller: 'DrinkRecipeDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['DrinkRecipe', function(DrinkRecipe) {
                                return DrinkRecipe.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('drinkRecipe', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('drinkRecipe.delete', {
                parent: 'drinkRecipe',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/drinkRecipe/drinkRecipe-delete-dialog.html',
                        controller: 'DrinkRecipeDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['DrinkRecipe', function(DrinkRecipe) {
                                return DrinkRecipe.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('drinkRecipe', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
