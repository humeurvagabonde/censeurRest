'use strict';

describe('Service: adresse', function () {

  // load the service's module
  beforeEach(module('profilerApp'));

  // instantiate service
  var adresse;
  beforeEach(inject(function (_adresse_) {
    adresse = _adresse_;
  }));

  it('should do something', function () {
    expect(!!adresse).toBe(true);
  });

});
