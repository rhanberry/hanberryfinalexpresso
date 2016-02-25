'use strict';

angular.module('finaltestApp')
    .factory('Ingredients', function ($resource, DateUtils) {
        return $resource('api/ingredients/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    });
