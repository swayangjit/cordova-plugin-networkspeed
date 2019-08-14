/**
 * Jasmine Based test suites
 */
exports.defineAutoTests = function () {
  'use strict';

  describe('networkspeed', function () {
    it('should be defined', function () {
      expect(networkspeed).toBeDefined();
    });
  });
};
