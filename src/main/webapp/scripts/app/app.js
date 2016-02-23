'use strict';

angular.module('finaltestApp', ['LocalStorageModule', 
    'ngResource', 'ngCookies', 'ui.bootstrap', 'ui.router',  'infinite-scroll'])

    .run(function ($rootScope, $location, $window, $http, $state) {
        

        $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams) {
            $rootScope.toState = toState;
            $rootScope.toStateParams = toStateParams;
        });


        
        $rootScope.back = function() {
            // If previous state is 'activate' or do not exist go to 'home'

                $state.go($rootScope.previousStateName, $rootScope.previousStateParams);

        };
    })
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider, AlertServiceProvider) {

        AlertServiceProvider.showAsToast(true);




        $urlRouterProvider.otherwise('/');
        $stateProvider.state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'scripts/components/navbar/navbar.html',
                    controller: 'NavbarController'
                }
            },
            resolve: {

            }
        });

        $httpProvider.interceptors.push('errorHandlerInterceptor');
        $httpProvider.interceptors.push('notificationInterceptor');

    })
    .config(['$urlMatcherFactoryProvider', function($urlMatcherFactory) {
        $urlMatcherFactory.type('boolean', {
            name : 'boolean',
            decode: function(val) { return val == true ? true : val == "true" ? true : false },
            encode: function(val) { return val ? 1 : 0; },
            equals: function(a, b) { return this.is(a) && a === b; },
            is: function(val) { return [true,false,0,1].indexOf(val) >= 0 },
            pattern: /bool|true|0|1/
        });
    }]);
