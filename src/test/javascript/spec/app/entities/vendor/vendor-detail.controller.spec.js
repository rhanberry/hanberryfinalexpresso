'use strict';

describe('Controller Tests', function() {

    describe('Vendor Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockVendor, MockBakedGood;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockVendor = jasmine.createSpy('MockVendor');
            MockBakedGood = jasmine.createSpy('MockBakedGood');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity ,
                'Vendor': MockVendor,
                'BakedGood': MockBakedGood
            };
            createController = function() {
                $injector.get('$controller')("VendorDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'expressoApp:vendorUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
