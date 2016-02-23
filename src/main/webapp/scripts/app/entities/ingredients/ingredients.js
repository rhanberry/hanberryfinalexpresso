'use strict';

angular.module('finaltestApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('ingredients', {
                parent: 'entity',
                url: '/ingredientss',
                data: {
                    pageTitle: 'Ingredientss'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ingredients/ingredientss.html',
                        controller: 'IngredientsController'
                    }
                },
                resolve: {
                }
            })
            .state('ingredients.detail', {
                parent: 'entity',
                url: '/ingredients/{id}',
                data: {
                    pageTitle: 'Ingredients'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/ingredients/ingredients-detail.html',
                        controller: 'IngredientsDetailController'
                    }
                },
                resolve: {
                    entity: ['$stateParams', 'Ingredients', function($stateParams, Ingredients) {
                        return Ingredients.get({id : $stateParams.id});
                    }]
                }
            })
            .state('ingredients.new', {
                parent: 'ingredients',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/ingredients/ingredients-dialog.html',
                        controller: 'IngredientsDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    ingredientname: null,
                                    ingredientprice: null,
                                    ingredientunit: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('ingredients', null, { reload: true });
                    }, function() {
                        $state.go('ingredients');
                    })
                }]
            })
            .state('ingredients.edit', {
                parent: 'ingredients',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/ingredients/ingredients-dialog.html',
                        controller: 'IngredientsDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['Ingredients', function(Ingredients) {
                                return Ingredients.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('ingredients', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('ingredients.delete', {
                parent: 'ingredients',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/ingredients/ingredients-delete-dialog.html',
                        controller: 'IngredientsDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['Ingredients', function(Ingredients) {
                                return Ingredients.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('ingredients', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
