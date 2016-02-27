'use strict';

angular.module('expressoApp')
    .factory('BakedGood', function ($resource, DateUtils) {
        return $resource('api/bakedGoods/:id', {}, {
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
