var myApp = angular.module('myApp', []);

myApp.controller('appC', ['$scope', '$http', function ($scope, $http) {

    $http.get("http://localhost:8080/rest/hello/booklist")
        .success(function(data, status,hewaders,config) {
            $scope.books = data;
    });

}]);