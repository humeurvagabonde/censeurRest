'use strict';

describe('Controller: IdentiteCtrl', function () {

  // load the controller's module
  beforeEach(module('profilerApp'));

  var IdentiteCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    IdentiteCtrl = $controller('IdentiteCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
