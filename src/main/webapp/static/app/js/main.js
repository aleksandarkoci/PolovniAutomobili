var autoApp = angular.module('autoApp', ['ngRoute']);

autoApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/',{
			templateUrl : '/static/app/html/partial/home.html'
		})
		.when('/automobili', {
			templateUrl : '/static/app/html/partial/automobili.html'
		})
		.when('/automobili/edit/:aid', {
            templateUrl : '/static/app/html/partial/edit-automobili.html'
        })
		.otherwise({
            redirectTo: '/'
        });
}]);