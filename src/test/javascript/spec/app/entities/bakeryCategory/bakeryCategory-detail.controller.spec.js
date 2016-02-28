'use strict';

describe('Controller Tests', function() {

    describe('BakeryCategory Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockBakeryCategory, MockBakedGood;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockBakeryCategory = jasmine.createSpy('MockBakeryCategory');
            MockBakedGood = jasmine.createSpy('MockBakedGood');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'BakeryCategory': MockBakeryCategory,
                'BakedGood': MockBakedGood
            };
            createController = function() {
                $injector.get('$controller')("BakeryCategoryDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:bakeryCategoryUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
