'use strict';

angular.module('starterApp')
  .factory('MixpanelService', function ($window) {

    return {
      track: function (key, data) {

        if (_.has($window, 'mixpanel')) {
          var copy = _.cloneDeep(data);
          $window.mixpanel.track(key, copy); // use a copy to avoid that mixpanel adds attributes like 'token' to data.
        }

      }
    };

  });

