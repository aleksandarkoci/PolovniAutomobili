var autoApp = angular.module('autoApp');

autoApp.controller('editAutomobilaCtrl', function ($scope, $http, $routeParams, $location) {

	var url_base_automobili = "http://localhost:8080/api/automobili";
	var url_base_modeli = "http://localhost:8080/api/modeli";
	var url_base_marke = "http://localhost:8080/api/marke";

	var id = $routeParams.aid;

	$scope.automobil = {};
	$scope.automobil.id = "";
	$scope.automobil.godiste = "";
	$scope.automobil.kilometraza = "";
	$scope.automobil.cena = "";
	// $scope.automobil.model = 0;
	// $scope.automobil.model.marka = 0;

	var getAutomobile = function() {
		$http.get (url_base_automobili + '/' + id).then(
			function success(data) {
				$scope.automobil = data.data;
				console.log(data);
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!');
			}
		);
	}
	getAutomobile();

	var getMarke = function() {
		$http.get (url_base_marke).then(
			function success(data) {
				$scope.marke = data.data;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}
	getMarke();


	var getModele = function() {
		$http.get (url_base_modeli).then(
			function success(data) {
				$scope.modeli = data.data;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}
	getModele();

	$scope.loadModele = function() {
		console.log($scope.automobil.model.marka);
		$http.get (url_base_marke + '/' + $scope.automobil.model.marka.id + '/modeli').then(
			function success(data) {
				$scope.markeModeli = data.data;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}

	$scope.editAuta = function(id) {
		$http.put (url_base_automobili + '/' + $scope.automobil.id, $scope.automobil).then(
			function success(data) {
				$location.path('/automobili');
				console.log(data);
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!');
			}
		);
	}
});