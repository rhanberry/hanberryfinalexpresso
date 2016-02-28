'use strict';

angular.module('expressoApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('bakeryCategory', {
                parent: 'entity',
                url: '/bakeryCategorys',
                data: {
                    pageTitle: 'BakeryCategorys'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/bakeryCategory/bakeryCategorys.html',
                        controller: 'BakeryCategoryController'
                    }
                },
                resolve: {
                }
            })
            .state('bakeryCategory.new', {
                parent: 'bakeryCategory',
                url: '/new',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakeryCategory/bakeryCategory-dialog.html',
                        controller: 'BakeryCategoryDialogController',
                        size: 'lg',
                        resolve: {
                            entity: function () {
                                return {
                                    bakeryCategory: null,
                                    id: null
                                };
                            }
                        }
                    }).result.then(function(result) {
                        $state.go('bakeryCategory', null, { reload: true });
                    }, function() {
                        $state.go('bakeryCategory');
                    })
                }]
            })
            .state('bakeryCategory.edit', {
                parent: 'bakeryCategory',
                url: '/{id}/edit',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakeryCategory/bakeryCategory-dialog.html',
                        controller: 'BakeryCategoryDialogController',
                        size: 'lg',
                        resolve: {
                            entity: ['BakeryCategory', function(BakeryCategory) {
                                return BakeryCategory.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakeryCategory', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            })
            .state('bakeryCategory.delete', {
                parent: 'bakeryCategory',
                url: '/{id}/delete',
                data: {
                },
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'scripts/app/entities/bakeryCategory/bakeryCategory-delete-dialog.html',
                        controller: 'BakeryCategoryDeleteController',
                        size: 'md',
                        resolve: {
                            entity: ['BakeryCategory', function(BakeryCategory) {
                                return BakeryCategory.get({id : $stateParams.id});
                            }]
                        }
                    }).result.then(function(result) {
                        $state.go('bakeryCategory', null, { reload: true });
                    }, function() {
                        $state.go('^');
                    })
                }]
            });
    });
