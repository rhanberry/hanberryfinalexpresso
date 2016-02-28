'use strict';

describe('Controller Tests', function() {

    describe('Allergens Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockAllergens, MockBakedGood;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockAllergens = jasmine.createSpy('MockAllergens');
            MockBakedGood = jasmine.createSpy('MockBakedGood');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Allergens': MockAllergens,
                'BakedGood': MockBakedGood
            };
            createController = function() {
                $injector.get('$controller')("AllergensDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:allergensUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
