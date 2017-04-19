var app = angular.module("myApp" ,['ui.router']);
//gestion des routers 
app.config(function($stateProvider,$urlRouterProvider){
	$stateProvider.state('home',{
		url:'/home',
		templateUrl:'views/home.html',
		controller:'homeController'
	});
	$stateProvider.state('chercherProduits',{
		url:'/chercherProduits',
		templateUrl:'views/chercherProduits.html',
		controller:'MyController'
	});
	$stateProvider.state('newProduit',{
		url:'/newProduit',
		templateUrl:'views/newProduit.html',
		controller:'newProduitController'
	});
	
});
app.controller("homeController",function($scope,$http){});

app.controller("newProduitController",function($scope,$http){
	
	$scope.produit={} ; 
	$scope.mode = 0; 
	$scope.retourner=function()
	{$scope.mode = 0;
	$scope.produit=null ; 
	}
	$scope.addProduit = function(){
		$http.post("http://localhost:8080/produits" ,$scope.produit  ).then(successCallback, errorCallback);
		 function successCallback(response){
		      //success code
			 if ( response.data != null) alert ("Ajout avec succés"); 
			 $scope.produit=response.data; 
				$scope.mode = 1; 

		  }
		  function errorCallback(error){
		      console.log(error);  }
	}
});
app.controller("MyController",function($scope,$http) // scope  présente  le  modéle toutes  les objets  qui  seront affichés dans  la vue sont déja stockés dans  le service scope 
		{  // http pour faire  les interactions avec le serveur  envoi des rêquetes et  réçevoir des  réponses 
	$scope.pageProduits =  null ; 
	$scope.motCle= ""; 
	$scope.pageCourante = 0 ; 
	$scope.size=4 ;
	$scope.pages=[];
	$scope.chercherProduits = function (){
		$http.get('http://localhost:8080/findProduits?mc='+$scope.motCle+'&page='+$scope.pageCourante+'&size='+$scope.size).then(successCallback, errorCallback);

		  function successCallback(response){
		      //success code
			  $scope.pageProduits = response.data; 
			  $scope.pages = new Array(response.data.totalPages) ;
		  }
		  function errorCallback(error){
		      console.log(error);  }
	}  
	$scope.getProduits=function ()
	{
		$scope.pageCourante =0;
		$scope.chercherProduits();
	}
	  $scope.gotoPages = function  (i){
			$scope.pageCourante =i;
			$scope.chercherProduits();

	  }
		});                                         