'use strict';

describe('Controller Tests', function() {

    describe('DrinkRecipe Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockDrinkRecipe, MockIngredients;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockDrinkRecipe = jasmine.createSpy('MockDrinkRecipe');
            MockIngredients = jasmine.createSpy('MockIngredients');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'DrinkRecipe': MockDrinkRecipe,
                'Ingredients': MockIngredients
            };
            createController = function() {
                $injector.get('$controller')("DrinkRecipeDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:drinkRecipeUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
