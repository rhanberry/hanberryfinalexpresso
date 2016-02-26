'use strict';

angular.module('finaltestApp')
    .factory('Drinkrecipe', function ($resource) {
        return $resource('api/drinkrecipes/:id', {}, {
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
