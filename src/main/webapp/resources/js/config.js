(function() {
  requirejs.config({
    baseUrl: 'js/',
    paths: {
      'angular': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min', 'vendor/angular.min'],
      'angular-route': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-route.min', 'vendor/angular-route.min'],
      'angular-sanitize': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-sanitize.min'],
      'angular-cookies': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular-cookies.min'],
      'angular-animate': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min'],
      'angular-aria': ['https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min'],
      'angular-material': ['https://ajax.googleapis.com/ajax/libs/angular_material/1.0.7/angular-material.min'],
      'bootstrap': ['https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min', 'vendor/bootstrap.min'],
      'jquery': ['https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min', 'vendor/jquery-3.1.0.min']
    }
  });

}).call(this);
