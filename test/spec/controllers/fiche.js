'use strict';

describe('Controller: FicheCtrl', function () {

  // load the controller's module
  beforeEach(module('profilerApp'));

  var FicheCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    FicheCtrl = $controller('FicheCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
