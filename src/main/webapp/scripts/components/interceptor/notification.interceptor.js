 'use strict';

angular.module('finaltestApp')
    .factory('notificationInterceptor', function ($q, AlertService) {
        return {
            response: function(response) {
                var alertKey = response.headers('X-finaltestApp-alert');
                if (angular.isString(alertKey)) {
                    AlertService.success(alertKey, { param : response.headers('X-finaltestApp-params')});
                }
                return response;
            }
        };
    });
