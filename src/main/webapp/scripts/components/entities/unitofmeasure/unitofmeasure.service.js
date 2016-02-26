'use strict';

angular.module('finaltestApp')
    .factory('Unitofmeasure', function ($resource) {
        return $resource('api/unitofmeasures/:id', {}, {
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
