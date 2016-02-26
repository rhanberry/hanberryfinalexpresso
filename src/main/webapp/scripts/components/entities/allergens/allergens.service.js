'use strict';

angular.module('finaltestApp')
    .factory('Allergen', function ($resource) {
        return $resource('api/allergens/:id', {}, {
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
