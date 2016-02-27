'use strict';

angular.module('expressoApp')
    .factory('DrinkRecipe', function ($resource, DateUtils) {
        return $resource('api/drinkRecipes/:id', {}, {
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
