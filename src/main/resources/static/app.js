var app=angular.module("Myapp" ,[]);
app.controller("MyController" , function($scope , $http){
	$scope.pageProduits=null;
	$http.get("http://localhost:8080/contact")
	
	.success(function(data){
		alert("mande");
		$scope.pageProduits=data;
	});
	.error(function(err){
		alert("error");
		console.log(err);
	})
	
});