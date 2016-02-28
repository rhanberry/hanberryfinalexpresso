'use strict';

describe('Controller Tests', function() {

    describe('BakedGood Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockBakedGood, MockBakeryCategory, MockVendor, MockAllergens;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockBakedGood = jasmine.createSpy('MockBakedGood');
            MockBakeryCategory = jasmine.createSpy('MockBakeryCategory');
            MockVendor = jasmine.createSpy('MockVendor');
            MockAllergens = jasmine.createSpy('MockAllergens');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'BakedGood': MockBakedGood,
                'BakeryCategory': MockBakeryCategory,
                'Vendor': MockVendor,
                'Allergens': MockAllergens
            };
            createController = function() {
                $injector.get('$controller')("BakedGoodDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:bakedGoodUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
