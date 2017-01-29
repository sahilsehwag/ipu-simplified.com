(function() {
  var app, mainController;

  app = angular.module('app', ['ngRoute', 'ngMaterial']);

  mainController = app.controller('mainController', function($scope, $rootScope, $mdSidenav) {
    return $rootScope.openMainMenu = function() {
      return $mdSidenav('main-menu').toggle();
    };
  });

}).call(this);
