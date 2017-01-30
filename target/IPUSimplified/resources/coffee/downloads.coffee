#define(['angular'], (angular) ->

#)


app = angular.module('app')
downloadsController = app.controller('downloadsController', ($scope, $rootScope, $http) ->
    $scope.getMoreRows = (pdfType, start, end) ->
        $http
            .get('URL')
            .success( (response) ->
                const json = response
            )
            .error( () ->)
)