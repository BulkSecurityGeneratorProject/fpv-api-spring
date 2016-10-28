'use strict';

describe('Controller Tests', function() {

    describe('Floor Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockFloor, MockPlan, MockDesk;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockFloor = jasmine.createSpy('MockFloor');
            MockPlan = jasmine.createSpy('MockPlan');
            MockDesk = jasmine.createSpy('MockDesk');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Floor': MockFloor,
                'Plan': MockPlan,
                'Desk': MockDesk
            };
            createController = function() {
                $injector.get('$controller')("FloorDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'fpvApp:floorUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
