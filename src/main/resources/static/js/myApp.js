var myApp= angular.module("myApp",[]);
myApp.controller("HomeController", function($scope,$http){
	
});
myApp.controller("StudentController", function($scope,$http){
	 $scope.apprenant={};
	// $scope.saveApprenant=function(){
	// 	$http.post("/saveApprenant", $scope.apprenant)
	// 	.success(function(data){
	// 		$scope.apprenant=data;
	// 	});
	// }
	// Simple POST request example:
	$http({
	method: 'POST',
	url: '/saveApprenant',
	data: $scope.apprenant
	}).then(function successCallback(response) {
		$scope.apprenant=response;
	}, function errorCallback(response) {
		//alert("Echec enregistrement");
	}); 
});