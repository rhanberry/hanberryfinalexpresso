'use strict';

describe('Controller Tests', function() {

    describe('Ingredients Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockIngredients, MockUnitOfMeasure, MockDrinkRecipe;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockIngredients = jasmine.createSpy('MockIngredients');
            MockUnitOfMeasure = jasmine.createSpy('MockUnitOfMeasure');
            MockDrinkRecipe = jasmine.createSpy('MockDrinkRecipe');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Ingredients': MockIngredients,
                'UnitOfMeasure': MockUnitOfMeasure,
                'DrinkRecipe': MockDrinkRecipe
            };
            createController = function() {
                $injector.get('$controller')("IngredientsDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:ingredientsUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
