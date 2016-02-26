'use strict';

angular.module('finaltestApp')
    .factory('Bakedgood', function ($resource) {
        return $resource('api/bakedgoods/:id', {}, {
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
