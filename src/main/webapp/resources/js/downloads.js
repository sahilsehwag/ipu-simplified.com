(function() {
  var app, downloadsController;

  app = angular.module('app');

  downloadsController = app.controller('downloadsController', function($scope, $rootScope, $http) {
      $scope.getMoreRows = function(url, start, end) {

        const request = {
          method: 'POST',
          url: url,
          data: {
            start: start,
            end: end
          },
          headers: {
            //'Content-Type': 'application/json'
          }
        }

        $http(request)
            .then(function () {
              const json = response.data
              if (pdfType == 'NOTICES') {
                $scope.notices = response.notices
              }
              else if (pdfType == 'DATESHEETS') {
                $scope.datesheets = response.datesheets
              }
              else if (pdfType == 'RESULTS') {
                $scope.results = response.results
              }
            },
            function (response) {
              const status = response.status
            })
      }
  });

}).call(this);
