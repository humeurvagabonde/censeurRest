'use strict';

describe('Controller: TelephoneCtrl', function () {

  // load the controller's module
  beforeEach(module('profilerApp'));

  var TelephoneCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TelephoneCtrl = $controller('TelephoneCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
