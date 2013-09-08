'use strict';

describe('Service: CarnetTelephone', function () {

  // load the service's module
  beforeEach(module('profilerApp'));

  // instantiate service
  var CarnetTelephone;
  beforeEach(inject(function (_CarnetTelephone_) {
    CarnetTelephone = _CarnetTelephone_;
  }));

  it('should do something', function () {
    expect(!!CarnetTelephone).toBe(true);
  });

});
