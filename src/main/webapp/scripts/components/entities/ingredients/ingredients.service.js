'use strict';

angular.module('expressoApp')
    .factory('Ingredients', function ($resource, DateUtils) {
        return $resource('api/ingredientss/:id', {}, {
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
