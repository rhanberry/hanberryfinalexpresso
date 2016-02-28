'use strict';

describe('Controller Tests', function() {

    describe('UnitOfMeasure Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockUnitOfMeasure, MockIngredients;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockUnitOfMeasure = jasmine.createSpy('MockUnitOfMeasure');
            MockIngredients = jasmine.createSpy('MockIngredients');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'UnitOfMeasure': MockUnitOfMeasure,
                'Ingredients': MockIngredients
            };
            createController = function() {
                $injector.get('$controller')("UnitOfMeasureDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:unitOfMeasureUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
