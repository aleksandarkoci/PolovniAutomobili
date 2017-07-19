var autoApp = angular.module('autoApp');

autoApp.controller('automobiliCtrl', function ($scope, $http, $location) {

	var url_base_automobili = "http://localhost:8080/api/automobili";
	var url_base_modeli = "http://localhost:8080/api/modeli";
	var url_base_marke = "http://localhost:8080/api/marke";

// #############################################################################

	$scope.automobili = [];
	$scope.modeli = [];
	$scope.marke = [];

// #############################################################################

	$scope.pageNum = 0;
	$scope.totalPages = 0;

// #############################################################################

	$scope.automobil = {};
	$scope.automobil.id = "";
	$scope.automobil.godiste = "";
	$scope.automobil.kilometraza = "";
	$scope.automobil.cena = "";
	// $scope.automobil.model = "";
	// $scope.automobil.model.marka = "";

// #############################################################################

	$scope.trazeniAuto = {};
	$scope.trazeniAuto.model = 0;
	$scope.trazeniAuto.cenaOd = "";
	$scope.trazeniAuto.cenaDo = "";
	$scope.trazeniAuto.godOd = "";
	$scope.trazeniAuto.godDo = "";

	var getAutomobile = function() {

		var config = { params : {}};

		config.params.pageNum = $scope.pageNum;

		if($scope.trazeniAuto.model != 0) {
			config.params.model = $scope.trazeniAuto.model;
		}

		if($scope.trazeniAuto.cenaOd != "") {
			config.params.cenaOd = $scope.trazeniAuto.cenaOd;
		}

		if($scope.trazeniAuto.cenaDo != "") {
			config.params.cenaDo = $scope.trazeniAuto.cenaDo;
		}

		if($scope.trazeniAuto.godOd != "") {
			config.params.godOd = $scope.trazeniAuto.godOd;
		}

		if($scope.trazeniAuto.godDo != "") {
			config.params.godDo = $scope.trazeniAuto.godDo;
		}

		$http.get (url_base_automobili, config).then(
			function success(data) {
				$scope.automobili = data.data;
				$scope.totalPages = data.headers('totalPages');
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}
	getAutomobile();

	$scope.got_markeModeli = false;
	$scope.got_modele = false;
	$scope.got_marke = false;

	var getMarke = function() {
		$http.get (url_base_marke).then(
			function success(data) {
				$scope.marke = data.data;
				$scope.got_marke = true;
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
				$scope.got_modele = true;
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
				$scope.got_markeModeli = true;
				console.log(data);
			},
			function error(data) {
				console.log(data);
			}
		);
	}

// #############################################################################

	$scope.saveOrEdit = function(id) {

		if(id == "" || id == null) {
			addAuto();
		} else {
			editAuto();
		}
	}

	function addAuto() {
		if(!isNaN($scope.automobil.godiste) && !isNaN($scope.automobil.kilometraza) &&
			!isNaN($scope.automobil.cena)) {

			$http.post (url_base_automobili, $scope.automobil).then(
				function success(data) {
					alert('Succsess! Dodavanje uspesno!');
					console.log(data);
					getAutomobile();
					
				},
				function error(data) {
					console.log(data);
					alert('Nesto je pogresno!');
				}
			);
		}
	}

	function editAuto() {
		$http.put (url_base_automobili + '/' + $scope.automobil.id, $scope.automobil).then(
			function success(data) {
				console.log(data);
				getAutomobile();
			},
			function error(data) {
				console.log(data);
				alert('Nesto je pogresno!');
			}
		);
	}

// #############################################################################

	$scope.napred = function(){
        if($scope.pageNum < $scope.totalPages - 1){
            $scope.pageNum = $scope.pageNum + 1;
            getAutomobile();
        }
    };
    
    $scope.nazad = function(){
        if($scope.pageNum > 0) {
            $scope.pageNum = $scope.pageNum - 1;
            getAutomobile();
        }
    };

// #############################################################################

	$scope.search = function(){
        $scope.pageNum = 0;
        getAutomobile();                                 
    }

// #############################################################################

	$scope.delete = function(id) {
		$http.delete (url_base_automobili + '/' + id).then(
			function success(data) {
				$scope.automobil = data.data;
				console.log(data);
				getAutomobile();
			},
			function error(data) {
				alert('Nesto je pogresno!');
				console.log(data);
			}
		);
	}

// #############################################################################

	$scope.editInPage = function(id){
        $http.get(url_base_automobili + "/" + id).then(     
            function success(data){
                $scope.automobil = data.data; 
                $scope.auto = data.data;       
                console.log(data);
   
            },
            function error(data){
                alert('Nesto je pogresno!');
                console.log(data);
            }
        );
    }



    $scope.editAutomobilInSinglePage = function(id) {
    	$location.path("/automobili/edit/" + id);
    }
});